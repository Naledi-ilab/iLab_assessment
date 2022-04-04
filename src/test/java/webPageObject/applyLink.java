package webPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class applyLink {

    protected WebDriver driver;

    public applyLink(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    //Locators
    @FindBy(xpath = "//a[@class='wpjb-button wpjb-form-toggle wpjb-form-job-apply']")
    public WebElement applyLink;
}
