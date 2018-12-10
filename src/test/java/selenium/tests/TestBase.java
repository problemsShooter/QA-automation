package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestBase {

    static protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
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
        driver.quit();
        driver = null;
    }

    @AfterTest
    public void afterTest() {

    }

}
