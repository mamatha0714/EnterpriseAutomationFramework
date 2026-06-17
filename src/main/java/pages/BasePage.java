package pages;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import utils.ElementUtil;


public class BasePage {

    protected WebDriver driver;
    protected ElementUtil elementUtil;

    public BasePage() {

        this.driver = DriverFactory.getDriver();
        elementUtil = new ElementUtil();
    }
}