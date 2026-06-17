package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;


public class WaitUtils {

    private static final int TIMEOUT = 20;

    public static WebElement waitForVisibility(By locator) {

        WebDriverWait wait =
                new WebDriverWait(DriverFactory.getDriver(),
                        Duration.ofSeconds(TIMEOUT));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverFactory.getDriver(),
                        Duration.ofSeconds(TIMEOUT));

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }
}