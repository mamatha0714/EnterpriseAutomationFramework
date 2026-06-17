package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By username =
            By.id("user-name");

    private By password =
            By.id("password");

    private By loginBtn =
            By.id("login-button");

    public LoginPage enterUsername(String user) {

        elementUtil.type(username,user);

        return this;
    }

    public LoginPage enterPassword(String pass) {

        elementUtil.type(password,pass);

        return this;
    }

    public HomePage clickLogin() {

        elementUtil.click(loginBtn);

        return new HomePage();
    }
}