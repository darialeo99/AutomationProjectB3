package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // Setting up the web driver
        // WebDriverManager.chromedriver().set(); but we do not need it with selemium 4.21, but it selenium before we need Bony Garcia web driver manager
        // if you use older version than you need dependency for web driver manager - Bony Garcia

        // create an instance of webDriver
        WebDriver driver = new ChromeDriver(); // driver is going to

        // maximize the window

        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        // navigate to the web page
        driver.get("https://www.loopcamp.io");

        Thread.sleep(5000);

        driver.navigate().to("https://www.etsy.com");

        // navigate back
        driver.navigate().back();

        // navigate forward
        driver.navigate().forward();

        // refresh
        driver.navigate().refresh();

        // quit and close
        //driver.close();

        driver.quit();






    }


}
