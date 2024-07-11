package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/*
  go to https://loopcamp.vercel.app/nested-frames.html
  validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

   */

public class T0_iframe_practice extends TestBase {

    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top"); // switching to parent frame that contains 3 frames
        driver.switchTo().frame("frame-left");

        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();

        Assert.assertEquals(actualLeft.trim(), "LEFT");

    }

    @Test
    public void middle () {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top"); // switching to parent frame that contains 3 frames
        driver.switchTo().frame("frame-middle");

        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        String actualMiddle = middle.getText();

        Assert.assertEquals(actualMiddle.trim(), "MIDDLE");

    }

    @Test
    public void right () {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top"); // switching to parent frame that contains 3 frames
        driver.switchTo().frame("frame-right");

        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        String actualRight = right.getText();

        Assert.assertEquals(actualRight.trim(), "RIGHT");
    }

    @Test
    public void bottom () {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        //driver.switchTo().frame("frame-top"); // switching to parent frame that contains 3 frames
        driver.switchTo().frame("frame-bottom");

        WebElement buttom = driver.findElement(By.xpath("//*[contains(text(), 'BOTTOM')]"));
        String actualBottom = buttom.getText();

        Assert.assertEquals(actualBottom.trim(), "BOTTOM");
    }
}
