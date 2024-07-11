package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtilities {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedURL
     * @param expectedTitle
     * @author nadir
     * implements assertion
     */

    public static void switchWindowAndValidate (WebDriver driver, String expectedURL, String expectedTitle) {

        expectedTitle = expectedTitle.toLowerCase();
        expectedURL = expectedURL.toLowerCase();

        Set <String> windowHandles = driver.getWindowHandles();

        for (String eachWindow: windowHandles) {
            driver.switchTo().window(eachWindow);

            if (driver.getTitle().toLowerCase().contains(expectedTitle)) {
                break;

            }
        }

        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));



    }


    /**
     *
     * @param driver
     * @param targetTitle
     * @author nadir
     */


    public static void switchToWindow (WebDriver driver, String targetTitle) {

        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);

            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }

        driver.switchTo().window(origin);

    }
}
