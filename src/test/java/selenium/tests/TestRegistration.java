package selenium.tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.DataUsers;
import selenium.pageObject.PageShopRegistration;
import selenium.actions.Registration;

public class TestRegistration extends TestBase {

    @Test(dataProvider = "users", dataProviderClass = DataUsers.class)
    public void verifyUserRegistration(User user) {
        PageShopRegistration pageShopRegistration = PageShopRegistration.open(driver);

        Registration.registration(pageShopRegistration, user);
        Assert.assertEquals(user.getFirstName() + " " + user.getSecondName(), driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText());
    }
}
