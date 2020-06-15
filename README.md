# Join-Assembly Automation Suite
Using a chromedriver to test join assembly following flow:
1. Go to joinassembly.com
2. Search for the email field in the page and list the number of email fields available
3. Focus on the second Email field and test the following
4. Enter ‘abc@gmail.com’, click on ‘Try for Free’ and test.
5. Enter ‘abc@carrothr.com’, click on ‘Try for Free’ and test.
6. Clicking on ‘Feature’ in the header should navigate to the Feature section.
7. By default, ‘Recognition’ tab should be highlighted.
8. Clicking on ‘Anniversaries and Birthdays’ should enable this tab and disable all other tabs
9. Scroll to footer and click on ‘Contact Us’ under Support
10. A chat widget will open
11. Enter ‘Slack’ in ‘Find an answer yourself’ field and verify the results displayed.

## Dependencies
1. Selenium
2. TestNG
3. log4j

## Set-Up & run the project:
1. ```Java1.8 or greater```
2. ```Maven as Build Tool/Dependency Management```
3. download chromedriver
4. Enter chromedriver location in config.properties file
5. Run the command ```mvn clean test```
