package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import driver.BrowserFactory;
import driver.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
    	
    	

        WebDriver driver = BrowserFactory.initializeBrowser(browser);
        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        if(DriverFactory.getDriver() != null) {

            DriverFactory.getDriver().quit();

            DriverFactory.unload();
        }
    }
}