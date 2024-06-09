package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the brower
 */
public class GoogleSearch {
    public static void main(String[] args) {

        // in selenium 3 we had to set up the driver, for that we need webdriver manager libraries

        // WebDriverManager.chromedriver().set() , and input dependency for it (for old selenium version)

        // --------------------------------------------------------------------------------------
        // Currently we need to do like that:

        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com");

        // maximize
        driver.manage().window().maximize();

        // Create the test to test the title page

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();   // new method
       // System.out.println(driver.getTitle());

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title is: " + actualTitle + " , matches the expected title: " + expectedTitle + ". => TEST PASS");
        }else {
            System.err.println("Actual title is: " + actualTitle + " , DOES NOT match the expected title: " + expectedTitle + ". => TEST FAIL");
        }

        // get URL method
        //System.out.println(driver.getCurrentUrl());

        String expectedURL = "https://www.google.com";
        String actualURL = driver.getCurrentUrl();    // new method

        if (actualURL.contains(expectedURL)) {
            System.out.println("Actual URL : " + actualURL + " , matches the expected URL: " + expectedURL + ". => TEST PASS");
        }else {
            System.err.println("Actual URL : " + actualURL + " , DOES NOT match the expected URL: " + expectedURL + ". => TEST FAIL");
        }

        driver.quit();


    }
}
