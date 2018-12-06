package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    static protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        String exePath = "C:\\Set of program\\driverChrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver  = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
        driver = null;
    }

}
