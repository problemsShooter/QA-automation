package selenium;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSignIn extends TestBase {

    @Test(dataProvider = "users", dataProviderClass = DataUsers.class)
    public void signIn(User user) {

        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.inputEmail.sendKeys(user.getEmail());
        pageShopSignIn.getButtonCreateAnAccount().click();
        Assert.assertNotNull(driver.findElements(By.xpath("//*[@id=\"noSlide\"]/h1")));
    }
}
