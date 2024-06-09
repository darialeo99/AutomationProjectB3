package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) {
        /*
         * go to docuport
         * enter username
         * do NOT enter password
         * click on login button
         * verify error message - please enter password
         */

        // go to the url

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        //enter username
        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        // finding login button element (By ClassName)

        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click(); // click on login button

        // verify error message - please enter password

        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
        //System.out.println(errorMessage.getText()); // got the text from the webpage "Please enter your password" and printed it in the console
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
            System.out.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " + actualErrorMessage + " => TEST PASS");
        }else {
            System.err.println("Expected error message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", does not match actual error message: " + actualErrorMessage + " => TEST FAIL");
        }

        driver.quit();


    }
}
