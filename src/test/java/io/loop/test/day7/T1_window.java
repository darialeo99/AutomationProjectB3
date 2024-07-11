package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
/*
1. Open a chrome browser
2. Go to : http://the-internet.herokuapp.com/windows
3. Assert: Title is “The Internet”
4. Click to: “Click Here” link
5. Switch to new Window.
6. Assert: Title is “New Window”
 */
public class T1_window  extends TestBase {

    @Test
    public void test_window () {
        driver.get("http://the-internet.herokuapp.com/windows");
        assertEquals(driver.getTitle(), "The Internet", "Results are NOT matching");

        System.out.println(driver.getWindowHandle() + ": this is window's unique ID"); // this is the window's handle that belongs to this window - unqiue ID

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();


        System.out.println("driver.getTitle() " + driver.getTitle()); // will still show the old title from the old window "The internet", we need to switch to a new window

        String originalWindow = driver.getWindowHandle(); // assigning original window handle and assign in to String



        // switching to a new window

        Set<String> windowHandles = driver.getWindowHandles(); // we have both window handles for both tabs// here I get all window handles

        for (String EachWindowHandle : windowHandles) { // loop through and stay at the last window
            System.out.println("each window handle is " + EachWindowHandle);
            driver.switchTo().window(EachWindowHandle); // switching to the latest one

        }

        System.out.println("driver.getTitle() " + driver.getTitle());

        // here I switch to the original window
        driver.switchTo().window(originalWindow);

        // printing out the title of the original window

        System.out.println("driver.getTitle() " + driver.getTitle());


    }

    @Test
    public void selenium4_window() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.switchTo().newWindow(WindowType.WINDOW); // will open a bare new WINDOW
        driver.switchTo().newWindow(WindowType.TAB); // will open empty blank new tab

    }


}
