# MindValley



This project has been implemented on TestNG framework using JAVA , for assertions I've used Junit.

Logging - Log4J have been used for logging issues and capturing infos.
Screenshot: Added screenshot listeners to the code. It will take screenshot if any test fails.
Report: ExtentReport Library has been used for generating pie-chart reports. See Screenshot folder 
Utilities: Made Util function for webdriver waits
Design Pattern: Page Object Model -Page Factory is being used extensively.
Configurator:
  Ability to run tests for different browsers/OS by configuring - Just configure the config. properties file with your choice of browser
  Ability to run tests for different browsers(chrome/FF/Safari) by configuring/by command-line. - Have used maven profiles here. Three XMLs have been created for this one  - chrome, FF, SAfari.. So you can run this from command line - mvn test -PChrome .   Here -P is "profiles" and "Chrome" is the environment configured in XML via parameterisation 
Reading test data from json file- This has been taken care of with Jackson library. It deserializes the json and converts it into java objects. Java getters facilitate in getting the values fromt he json which is being used across tests (say username, password, address ect)

So the flow is - 
Entry point would be - mvn test -PChrome .  >> (here chrome browser is invoked from the terminal or jenkins). This is managed by maven.Maven invokes the profile (chromeBrowser.xml in this case) and from 
this xml it will go to the VerifyHomePage test class. It will run the @AfterTest annotated method. Here different implementations are provided
based upon the input. So if input is chrome, ChromeDriverManager will be instantiated. This pattern is called Abstract Factory Pattern which is used for creating different types of browser driver without 
thinking much about how its being implemented. Also for Driver connection, singleton Pattern is being used. So at a time only one instance will be there.
After this , it will start running the tests and at then end driver.quit will be invoked in driverManager class.

The code works for Chrome and Firefox, . For safari right I was not able to finish it because of lack of time. :(
