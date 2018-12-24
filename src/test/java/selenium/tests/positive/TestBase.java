package selenium.tests.positive;

import lombok.Data;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import selenium.data.DataPool;

@Listeners(TakeScreenShotOnFailure.class)
public class TestBase {

    static protected WebDriver driver;
    protected DataPool<User> dataUsersPool;
    protected static final Logger LOGGER = LogManager.getLogger(
            TestAccountData.class.getName());

    @BeforeSuite()
    public void beforeSuite(ITestContext testContext) {

    }

    @Parameters({"keyTypeUsersForCheck","dataFile"})
    @BeforeClass()
    public void beforeClass(String keyTypeUsersForCheck,String dataFile) {
        dataUsersPool = new DataPool<User>(User.class);
        dataUsersPool.processDataFile(new User(), dataFile, keyTypeUsersForCheck);//file to pass in parameters
    }

    @BeforeMethod
    public void beforeMethod() {
        String exePath = "C:\\Set of program\\driverChrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {

    }

    @AfterMethod
    public void afterMethod() {
/*        driver.quit();
        driver = null;*/
    }
@AfterClass
public void afterClass(){

}
    @AfterTest
    public void afterTest() {

    }

    @BeforeTest
    public void beforeTest() {

    }


}
