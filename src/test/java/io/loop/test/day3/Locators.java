package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        // create the driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com");

        // maximize
        driver.manage().window().maximize();

        // locate the element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb")); // searching element by ID on Google page (Inspect)

        WebElement searchBoxWithName = driver.findElement(By.name("q")); // searching element by name on Google page (Inspect)

        WebElement aboutLink = driver.findElement(By.linkText("About"));

        //aboutLink.click();


        String textToSearch = "Feyruz is smart";


        searchBoxWithID.sendKeys("Nadir is smart");

        Thread.sleep(3000);

        searchBoxWithID.clear();

        Thread.sleep(3000);


        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER); // send this text to the search bar in Google and Click "Enter" to search
       // searchBoxWithName.sendKeys(textToSearch + Keys.ENTER); // we will get the same result




    }
}
