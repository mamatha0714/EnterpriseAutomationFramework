package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By productsTitle =
            By.xpath("//span[text()='Products']");

    public boolean isHomePageDisplayed() {

        return driver.findElement(productsTitle)
                     .isDisplayed();
    }
}