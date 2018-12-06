package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario extends TestBase {

    @Test
    public void testShopOpenIndexPage() {
        String expectedTitle = "My Store";
        PageShop pageShop = PageShop.open(driver);
        Assert.assertEquals(expectedTitle, pageShop.getTitle());

//        Random random = new Random();
//        RandomString randomMail = new RandomString(10);
//        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        driver.get("http://automationpractice.com");
//
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
//        String email = randomMail.nextString()+"@qmail.com";
//        driver.findElement(By.id("email_create")).sendKeys(email);
//        driver.findElement(By.id("SubmitCreate")).click();
//        driver.findElement(By.id("id_gender1")).click();
//        driver.findElement(By.id("customer_firstname")).sendKeys("Vitaly");
//
//        driver.findElement(By.id("customer_lastname")).sendKeys("Grebnev");
//        driver.findElement(By.id("passwd")).sendKeys("zxcasdqwe123");
//
//        Select sel1 = new Select(driver.findElement(By.id("days")));
//        sel1.selectByIndex(random.nextInt(29));
//        Select sel2 = new Select(driver.findElement(By.id("months")));
//        sel2.selectByIndex(random.nextInt(12));
//        Select sel3 = new Select(driver.findElement(By.id("years")));
//        sel3.selectByIndex(random.nextInt(119));
//
//        driver.findElement(By.id("newsletter")).click();
//        driver.findElement(By.id("optin")).click();
//        driver.findElement(By.id("company")).sendKeys("YourLoda");
//        driver.findElement(By.id("address1")).sendKeys("Baker 32 street, floor 3");
//        driver.findElement(By.id("city")).sendKeys("London");
//
//        Select sel4 = new Select(driver.findElement(By.id("id_state")));
//        sel4.selectByIndex(6);
//
//        driver.findElement(By.id("postcode")).sendKeys("99501");
//
//        Select sel5 = new Select(driver.findElement(By.id("id_state")));
//        sel5.selectByIndex(2);
//
//        driver.findElement(By.id("other")).sendKeys("additional information");
//
//        driver.findElement(By.id("phone")).sendKeys("8(999) 99 99 99");
//        driver.findElement(By.id("phone_mobile")).sendKeys("8 (999) 999 99 99");
//
//        driver.findElement(By.id("alias")).sendKeys("1.473");
//        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
//        driver.findElement(By.id("email")).sendKeys(email);
//        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("zxcasdqwe123");
//        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

        //driver.quit();
    }
    @Test
    public void testOpenShopSignIn(){
        String expectedTitle = "Login - My Store";
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        Assert.assertEquals(expectedTitle, pageShopSignIn.getTitle());
    }
    @Test
    public void testOpenShopRegistration(){
        String expectedTitle = "Login - My Store";
        PageShopRegistration pageShopRegistration = PageShopRegistration.open(driver);
        Assert.assertEquals(expectedTitle, pageShopRegistration.getTitle());
    }
}
