package webUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class utilities {

    protected  static WebDriver driver;

    public  static WebDriver getDriver(){

        return driver;
    }

    public  void setDriver(WebDriver DriverTest){

        driver = DriverTest;
    }

    public WebDriver initializeWebDriver(String sBrowser){

        switch (sBrowser.toUpperCase()){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MICROSOFT EDGE" :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "IE":
                WebDriverManager.chromiumdriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;

    }

    public void navigate(String URL) throws InterruptedException{
        driver.get(URL);
        Thread.sleep(2000);
    }
}
