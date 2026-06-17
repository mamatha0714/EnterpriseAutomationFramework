Java, Selenium, TestNG, Maven, Jenkins, Docker, Selenium Grid, and Allure Reports.
EnterpriseAutomationFramework

src/test/java

base
│
├── BaseTest
├── BrowserFactory
├── DriverFactory

pages
│
├── login
├── products
├── cart
├── checkout
├── common

utilities
│
├── ConfigManager
├── ElementUtil
├── WaitUtil
├── ScreenshotUtil
├── AssertionUtil
├── LoggerUtil

listeners
│
├── TestListener
├── RetryAnalyzer

resources
│
├── qa.properties
├── uat.properties
├── prod.properties
├── log4j2.xml
├── testng.xml

reports
screenshots
allure-results

Jenkinsfile
docker-compose.yml
