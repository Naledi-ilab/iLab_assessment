package webTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import dataBase.dataSource;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.functions;
import report.reporting;
import webUtilities.utilities;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class iLabPage extends utilities{

    public utilities web = new utilities();
    public functions functions = new functions();
    public reporting repo = new reporting ();


    String url,browser;
    ExtentReports reports;

    dataSource data = new dataSource();
    ResultSet set;


    @Parameters({"Browser","iLabUrl"})
    @BeforeTest
    public void init(String sBrowser,String sUrl){
        browser= sBrowser;
        url = sUrl;

        web.setDriver(web.initializeWebDriver(sBrowser));
        reports = repo.initializeExtentReports("reports/test.html");
    }


    @Test
    public void page() throws InterruptedException, SQLException, IOException {

        ExtentTest test = reports.createTest("iLab page");
        test.assignAuthor("Naledi Constable");
        ExtentTest node;

       try {

          set = data.ConnectAndQuerySQL("jdbc:mysql://localhost:3306/test","root","root","select * from info");

           web.navigate(url);
            int iRow = data.rowCount(set);
            for (int i = 1; i <= iRow; i++) {
                if (set.next()) {
                    functions.openCareersLink(utilities.getDriver(),test);
                    functions.openCountryLink(utilities.getDriver(), test);
                    functions.openFirstOptionLink(utilities.getDriver(), test);
                    functions.openApplyLink(utilities.getDriver(), test);
                    functions.openWebForm(utilities.getDriver(),set,test);
                }
            }
            set.close();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
}

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        utilities.getDriver().quit();
        reports.flush();
    }
}
