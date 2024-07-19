package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
1. Go to https://www.etsy.com
2. Scroll down
3. Generate random email and enter into subscribe box
4. Click on Subscribe
5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
*/
public class T3_JSExecutor_scroll {

    @Test
    public void loopcamp_scroll_test () throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/");
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));

        // how to scroll
        // #1 use actions move to elements

        Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(link).perform();  // first way

        //actions.scrollToElement(link).perform(); // second way

        //# 2 just use Key Press
        //actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //#3 move horizontally or vertically

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("window.scroll(0, 5000)"); // scroll down

        //#4 scroll to view
        js.executeScript("arguments[0].scrollIntoView(true)" , link);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()" , link); // click the link (element) and open it in the new tab
        js.executeScript("window.scroll(0, 500)");
    }


}
