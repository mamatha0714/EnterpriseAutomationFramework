package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage loginPage =
                new LoginPage();

        HomePage homePage =
                loginPage
                    .enterUsername(
                        ConfigReader.getProperty("username"))
                    .enterPassword(
                        ConfigReader.getProperty("password"))
                    .clickLogin();

        Assert.assertTrue(
                homePage.isHomePageDisplayed());
    }
}