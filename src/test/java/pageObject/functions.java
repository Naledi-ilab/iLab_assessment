package pageObject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import phoneNumber.randomNumber;
import report.reporting;
import webPageObject.*;
import webUtilities.actions;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.Duration;

public class functions extends actions {

    reporting repo = new reporting();


    public void openCareersLink(WebDriver driver, ExtentTest node) throws IOException {
        careersTab careersObj = new careersTab(driver);
        String filename = repo.CaptureScreenShot(driver);

        try {
            Thread.sleep(4000);
            clickObject(careersObj.careersLink, driver);

            if (careersObj.careersLink.isDisplayed()) {

                node.pass("careers tab link clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                System.out.println("careers tab link clicked");

            } else {
                System.out.println("careers tab link not clicked");
                node.fail("careers tab link not clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unsuccessful! careers tab link not found");
        }
    }//end of method


    public void openCountryLink(WebDriver driver, ExtentTest node) throws IOException {

        countryLink linkObj = new countryLink(driver);
        String filename = repo.CaptureScreenShot(driver);


        try {

            Thread.sleep(3000);
            clickObject(linkObj.southAfricaLink, driver);
            node.pass("country link clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

        } catch (Exception e) {
            e.printStackTrace();
            //node.fail("unsuccessfully, clicked careers", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            Assert.fail("Unsuccessful, country link not found! ");
        }

    }//end of method


    public void openFirstOptionLink(WebDriver driver, ExtentTest node) throws IOException {

        jobLink firstObj = new jobLink(driver);
        String filename = repo.CaptureScreenShot(driver);

        try {
            Thread.sleep(3000);
            clickObject(firstObj.firstLink, driver);
            node.pass("Successfully first option link clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            System.out.println("Successfully first option link clicked");

        } catch (Exception e) {
            node.fail("unsuccessful, first option link not clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            e.printStackTrace();
        }

    }//end of method


    public void openApplyLink(WebDriver driver, ExtentTest node) throws IOException {
        applyLink apply = new applyLink(driver);
        String filename = repo.CaptureScreenShot(driver);

        try {
            Thread.sleep(3000);
            clickObject(apply.applyLink, driver);
            node.pass("apply link clicked ", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            System.out.println("apply link clicked");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("apply link not clicked");
            node.fail("apply link not clicked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        }
    }//end of method


    public void openWebForm(WebDriver driver, ResultSet rs, ExtentTest node) throws IOException {
        webForm form = new webForm(driver);
        String filename = repo.CaptureScreenShot(driver);
        randomNumber random = new randomNumber();
        errorMessageValidate error = new errorMessageValidate();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            passData(form.txtUsername, driver, rs.getString("Name"));
            passData(form.txtEmail, driver, rs.getString("email_adress"));
            passData(form.txtPhone, driver, random.getRandomNumberString());
            passData(form.txtMsg, driver, rs.getString("message"));
            clickObject(form.submitBtn, driver);

            error.errorValidate(driver,node);
        } catch (Exception e) {
            System.out.print(" " + e.getMessage());

        }
    }//end of method


}
/***
 * Author: Naledi Constable
 * class : functions , Class contains methods that navigate through the iLab web page and fills in web form
 * Methods: openCareersLink()
 * Navigates to the careers link and clicks the link opening a new page
 *
 *         openCountryLink()
 *  Navigates to the South Africa link under careers page and clicks the link opening a new page
 *
 *         openFirstOptionLink
 * Navigates to the first option on the and clicks it
 *
 *         openApplyLink()
 * Navigates to the careers link and clicks the link opening a new page
 *
 *         openWebForm()
 * Passes values stored from the database (mysql) filling the form and calls the method getRandomNumberString() from the randomNumber class and
 * calls the method errorValidate() from the errorMessageValidate class
 *
 */
