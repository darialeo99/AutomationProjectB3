package io.loop.test.day8;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
/*
1. Go to “http://demo.guru99.com/test/upload”
2. Upload file into Choose File
3. Click terms of service check box
4. Click Submit File button
5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
*/
public class T3_upload {

    @Test
    public void upload_file() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("guru.url"));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));

        //getting path to the file

        String path = "C:\\Users\\leonda\\Desktop\\note.txt.txt";
        // sending this file
        chooseFile.sendKeys(path);

        WebElement CheckBox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        CheckBox.click();

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='button']"));
        submitButton.click();

        Thread.sleep(3000);
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//h3[@id='res']"));

        String expected = "1 file\n" +
                "has been successfully uploaded.";

        assertEquals(expected, successMessage.getText());


    }


}
