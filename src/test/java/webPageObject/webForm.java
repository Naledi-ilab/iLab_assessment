package webPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class webForm {

    protected WebDriver driver;

    public webForm(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy (xpath = "//input[@id='applicant_name']")
    public WebElement txtUsername;

    @FindBy (xpath = "//input[@id='email']")
    public WebElement txtEmail;

    @FindBy (xpath = "//*[@id=\"phone\"]")
    public WebElement txtPhone;

    @FindBy (xpath = "//*[@id=\"message\"]")
    public WebElement txtMsg;

    @FindBy (xpath = "//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul")
    public WebElement txtErrorMsg;

    @FindBy (xpath = "//input[@id='wpjb_submit']")
    public WebElement submitBtn;


}
