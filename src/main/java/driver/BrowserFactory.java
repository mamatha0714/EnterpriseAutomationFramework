package driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BrowserFactory {

    public static WebDriver initializeBrowser(String browser) {

        String executionMode =
                ConfigReader.getProperty("executionMode");

        if ("remote".equalsIgnoreCase(executionMode)) {

            return createRemoteDriver(browser);

        } else {

            return createLocalDriver(browser);
        }
    }

    private static WebDriver createLocalDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions =
                        getChromeOptions();

                driver = new ChromeDriver(chromeOptions);

                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions =
                        getFirefoxOptions();

                driver = new FirefoxDriver(firefoxOptions);

                break;

            case "edge":

                WebDriverManager.edgedriver().setup();

                EdgeOptions edgeOptions =
                        getEdgeOptions();

                driver = new EdgeDriver(edgeOptions);

                break;

            default:

                throw new RuntimeException(
                        "Unsupported browser : "
                                + browser);
        }

        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver createRemoteDriver(String browser) {

        try {

            URL gridUrl =
                    new URL(
                            ConfigReader.getProperty("gridUrl"));

            switch (browser.toLowerCase()) {

                case "chrome":

                    return new RemoteWebDriver(
                            gridUrl,
                            getChromeOptions());

                case "firefox":

                    return new RemoteWebDriver(
                            gridUrl,
                            getFirefoxOptions());

                case "edge":

                    return new RemoteWebDriver(
                            gridUrl,
                            getEdgeOptions());

                default:

                    throw new RuntimeException(
                            "Unsupported browser : "
                                    + browser);
            }

        } catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Invalid Grid URL", e);
        }
    }

    private static ChromeOptions getChromeOptions() {

        ChromeOptions options =
                new ChromeOptions();

        options.addArguments("--start-maximized");

        options.addArguments(
                "--disable-notifications");

        options.addArguments(
                "--incognito");

        String headless =
                ConfigReader.getProperty("headless");

        if ("true".equalsIgnoreCase(headless)) {

            options.addArguments(
                    "--headless=new");
        }

        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {

        FirefoxOptions options =
                new FirefoxOptions();

        String headless =
                ConfigReader.getProperty("headless");

        if ("true".equalsIgnoreCase(headless)) {

            options.addArguments("-headless");
        }

        return options;
    }

    private static EdgeOptions getEdgeOptions() {

        EdgeOptions options =
                new EdgeOptions();

        String headless =
                ConfigReader.getProperty("headless");

        if ("true".equalsIgnoreCase(headless)) {

            options.addArguments(
                    "--headless=new");
        }

        return options;
    }
}