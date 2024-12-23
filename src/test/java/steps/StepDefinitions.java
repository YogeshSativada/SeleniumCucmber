package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinitions {

	WebDriver driver;
	
	@After
	public void teardown() {
	try {
	Thread.sleep(3000);
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	driver.quit();

	}

	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {

		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@When("user enters text {string} in textbox using xpath {string}")
	public void user_enters_text_in_textbox_using_xpath(String text, String xpath) {

		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user verify the title of page to be {string}")
	public void user_verify_the_title_of_page_to_be(String expTitle) {

		Assert.assertEquals(expTitle, driver.getTitle());

	}
	
	@Then("user verify the presence of text using xpath {string}")
	public void userVerifyThePresenceOfTextUsingXpath(String xpath , DataTable datatable) {
		
		List<Map<String, String>> listOfMaps = datatable.asMaps();
		
		String actualText=driver.findElement(By.xpath(xpath)).getText();

	     System.out.println(actualText);

		 System.out.println(listOfMaps.get(0).get("error message"));
		 
		 Assert.assertEquals(listOfMaps.get(0).get("error message"), actualText);
	}
}