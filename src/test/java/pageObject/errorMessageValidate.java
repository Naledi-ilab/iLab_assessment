package pageObject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import phoneNumber.randomNumber;
import report.reporting;
import webPageObject.webForm;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.Duration;

public class errorMessageValidate {
    public reporting repo = new reporting ();


    public void errorValidate(WebDriver driver, ExtentTest node) throws IOException, InterruptedException {
        webForm form = new webForm(driver);
        String filename = repo.CaptureScreenShot(driver);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.urlContains("https://www.ilabquality.com/job/bsc-computer-science-national-diploma-it-development-graduates/?form=apply#wpjb-scroll"));
        if (form.txtErrorMsg.isDisplayed()) {
            node.pass("Error message is displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            System.out.println("negative test passed");
        } else {
            node.fail("Oops no error message shown  ", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            System.out.println("negative test failed");

        }
        Thread.sleep(5000);
    }
}
/**
 * Author : Naledi Constable
 *Class: errorMessageValidate
 * Method: errorValidate()
 * the method waits for the expected condition to pass before running the if statement to check if the error message has been displayed after submission
 *
 *
 */
