package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

/*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */
public class T1_findElements {

    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.nba.com");

        //WebElement element = driver.findElement(By.tagName("a"));

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks.size() = " + nbaLinks.size());

        List <WebElement> nbaLinksXpath = driver.findElements(By.xpath("//a")); // a thing used for getting all the tags
        System.out.println("nbaLinks.Xpath.size() = " + nbaLinksXpath.size());

        for (WebElement nbaLink : nbaLinks) {

            if (!nbaLink.getText().equals("")) { // if the links are not empty

                System.out.println("nbaLink.getText() = " + nbaLink.getText()); // getting all the text
                System.out.println("nbaLink.getAttribute (href) = " + nbaLink.getAttribute("href")); // getting all the links // href thing is used for Links


            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) {

            if (!nbaLinks.get(i).getText().equals("")) {

                System.out.println("nbaLinks.get(i).getText() = " + nbaLinks.get(i).getText());
                System.out.println("nbaLinks.get(i).getAttribute (href) = " + nbaLinks.get(i).getAttribute("href"));

            }

        }

    }
}
