package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_css {

    /*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"
     */

    //the rest is home work

    /*
    locate:
     username
     password
     login
        with css

     login to docuport
     locate home icon of docuport after login or any other element after login
     validate that you logged in
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        // 3. click on forgot password

        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        // 4. validate url contains: reset password
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(DocuportConstants.RESET_PASSWORD)){
            System.out.println("Actual url matches expected one");
        } else {
            System.err.println("Actual url DOES NOT match expected one");
        }

        //5. validate - Enter the email address associated with yor account
        WebElement validateMessage = driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        // 6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);


        // 7. validate send button is displayed
        // 8. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if(cancelButton.isDisplayed()){
            System.out.println("Test pass - cancel is displayed");
        } else {
            System.out.println("Test fail - cancel is not displayed");
        }

        if(sendButton.isDisplayed()){
            System.out.println("Test pass - send is displayed");
        } else {
            System.out.println("Test fail - send is not displayed");
        }

        // 9. click send button

        sendButton.click();

        Thread.sleep(3000);

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(5000);

        // String actualMessage = successMessage.getText();

        // System.out.println("actualMessage = " + actualMessage);

        try{
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }



    }
}
