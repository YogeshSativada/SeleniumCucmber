Feature: To validate login Functionality of Adactin HotelApp

Scenario: To validate login using valid username and valid password

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text "yogesh6855" in textbox using xpath "//input[@name='username']"
And user enters text "Target@2025" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verify the title of page to be "Adactin.com - Search Hotel"

@test2333
Scenario: To validate login using valid username and invalid password

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text "yogesh6855" in textbox using xpath "//input[@name='username']"
And user enters text "invalidPswd" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verify the presence of text using xpath "//div[@class='auth_error']/b"
| error message|
|Invalid Login details or Your Password might have expired. Click here to reset your password|
Then user verify the title of page to be "Adactin.com - Hotel Reservation System"

