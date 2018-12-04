package selenium;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestScenario {
    @BeforeMethod
    public void beforeMethod(){
        String exePath = "C:\\Set of program\\driverChrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
    }

    @Test
    public void method() {

        WebDriver driver = new ChromeDriver();
        Random random = new Random();
        RandomString randomMail = new RandomString(10);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email_create")).sendKeys(randomMail.nextString()+"@qmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Vitaly");

        driver.findElement(By.id("customer_lastname")).sendKeys("Grebnev");
        driver.findElement(By.id("passwd")).sendKeys("zxcasdqwe123");

        Select sel1 = new Select(driver.findElement(By.id("days")));
        sel1.selectByIndex(random.nextInt(31));
        Select sel2 = new Select(driver.findElement(By.id("months")));
        sel2.selectByIndex(random.nextInt(12));
        Select sel3 = new Select(driver.findElement(By.id("years")));
        sel3.selectByIndex(random.nextInt(119));

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("company")).sendKeys("YourLoda");
        driver.findElement(By.id("address1")).sendKeys("Baker 32 street, floor 3 ");
        driver.findElement(By.id("city")).sendKeys("London");

        Select sel4 = new Select(driver.findElement(By.id("id_state")));
        sel4.selectByIndex(6);

        driver.findElement(By.id("postcode")).sendKeys("99501");

        Select sel5 = new Select(driver.findElement(By.id("id_state")));
        sel5.selectByIndex(2);

        driver.findElement(By.id("other")).sendKeys("additional information");

        driver.findElement(By.id("phone")).sendKeys("8(999) 99 99 99");
        driver.findElement(By.id("phone_mobile")).sendKeys("8 (999) 999 99 99");

        driver.findElement(By.id("alias")).sendKeys("1.473");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();

        driver.quit();


    }

}
