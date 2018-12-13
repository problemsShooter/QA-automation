package selenium.tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import selenium.data.DataPool;

import java.util.HashMap;


public class TestBase {

    static protected WebDriver driver;
    protected DataPool<User> dataUsersPool;

    @BeforeSuite()
    public void beforeSuite(ITestContext testContext) {
        dataUsersPool = new DataPool<User>(User.class);
        dataUsersPool.processDataFile(new User(),"src/test/java/selenium/data/dataUsers.json","users");//file to pass in parameters
//        HashMap<String,String> parameters = new HashMap<String,String>( testContext.getCurrentXmlTest().getAllParameters());
//        dataPool.processDataFile( parameters.get( "dataFile" ) );
    }

    @BeforeMethod
    public void beforeMethod() {
        String exePath = "C:\\Set of program\\driverChrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() {

    }

    @AfterMethod
    public void afterMethod() {
//        driver.quit();
//        driver = null;
    }

    @AfterTest
    public void afterTest() {

    }



}
