package io.loop.test.day_6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
1- Open a chrome browser
2- Go to: https://loopcamp.vercel.app/iframe.html
3- Clear text from comment body
4- Type "Loop Academy" in comment body
5- Verify "Loop Academy" text is written in comment body
6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
 */
public class T2_iframe extends TestBase {

    @Test
    public void iframeTest () {
        driver.get("https://loopcamp.vercel.app/iframe.html");
        // locating iframe as web element and switching to a web element
//        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));// locating iframe element with xpath
//        driver.switchTo().frame(iframe); // elements name from line 21, now we are inside of iframe (we switched TO iframe)


        // another way locating iframe// switch to index 0 iframe // indexing in iframe the same as html starts from 0
       // driver.switchTo().frame(0);

        // another way locating iframe// with id
        driver.switchTo().frame("mce_0_ifr"); // with the id of the iframe



        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Loop Academy"); // sending "Loop Academy" text into the white box
        assertEquals(textBox.getText() , "Loop Academy", "Actual is NOT matching with expected"); // validating that "Loop Academy" text into the white box


        driver.switchTo().defaultContent(); // taking back to normal html there i was // default content is HTML content

        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));
        //System.out.println("textBox: " + header.getText());
        assertTrue(header.isDisplayed(), "The header is not displayed");



//        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));
//        System.out.println(header.getText());
//
//        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
//        System.out.println("textBox: " + textBox); // NoSuchElement Exception - means it's iframe
    }

    @Test
    public void NestedFrame () {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        List<WebElement> iframes;
        iframes = driver.findElements(By.xpath("//frame"));
        System.out.println("The quantity of iframes on this webpage " + iframes.size());

    }






}
