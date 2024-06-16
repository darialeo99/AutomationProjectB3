package io.loop.test.day3;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    /*
    go to url: https://loopcamp.vercel.app/registration_form.html
    verify header text expected:  Registration form
    verify placeholder attribute value expected - firstname
     */
    public static void main(String[] args) {

        // go to url
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        // locate element by tag name

        WebElement headerForForm = driver.findElement(By.tagName("h2"));
        //System.out.println(headerForForm.getText());
        String actualHeaderForForm = headerForForm.getText();

        if (actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)) {
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\" , matches actual header: \"" + actualHeaderForForm + "\" => TEST PASSED" );
        }else {
            System.err.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\" , does not match actual header: \"" + actualHeaderForForm + "\" => TEST FAILED" );
        }

        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));
        String actualPlaceHolderForFirstName =  firstNamePlaceholder.getAttribute("placeholder");

        //System.out.println("actualPlaceHolderForUserName " + actualPlaceHolderForUserName);

        if (actualPlaceHolderForFirstName.equals(LoopCampConstants.EXPECTED_PLACE_HOLDER_FIRSTNAME)) {
            System.out.println("Expected placeholder matches with actual");
            System.out.println("TEST PASSED");


        }else{
            System.out.println("Expected placeholder DOES NOT match with actual");
            System.err.println("TEST FAILED");
        }

    }
}
