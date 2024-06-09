package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/*
 * create a static method getDriver
 * Accepts argument String - browserType
 * returns webdriver
 */
public class WebDriverUtil {
    /**
     *
     * @param browser
     * @return the driver of that browser
     * @authot nsh
     */

    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();

        }else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();

        }else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }else {
            System.out.println("No driver found");
            System.out.println("Driver is null");
            return null;
        }
    }
}
