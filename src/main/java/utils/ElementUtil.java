package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementUtil {

    public void click(By locator) {

        WaitUtils.waitForClickable(locator).click();
    }

    public void type(By locator,String value) {

        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }

    public String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return WaitUtils.waitForVisibility(locator).isDisplayed();
    }
}