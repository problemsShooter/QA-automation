package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario {


        public static void main(String[] args) {
            String exePath = "C:\\Set of program\\driverChrome\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            WebDriver driver = new ChromeDriver();
            //driver.get("http://automationpractice.com");
            driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

            driver.close();
        }
}
