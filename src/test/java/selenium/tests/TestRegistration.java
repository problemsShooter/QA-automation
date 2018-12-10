package selenium.tests;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.DataUsers;
import selenium.pageObject.PageShopRegistration;
import selenium.actions.Registration;

public class TestRegistration extends TestBase {
    private static final Logger LOGGER = LogManager.getLogger(
            TestRegistration.class.getName());

    @Test(dataProvider = "users", dataProviderClass = DataUsers.class)
    public void verifyUserRegistration(User user) {
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info( "Info Message: verifyUserRegistration has been run !!!" );
        PageShopRegistration pageShopRegistration = PageShopRegistration.open(driver);

        Registration.registration(pageShopRegistration, user);
        Assert.assertEquals(user.getFirstName() + " " + user.getSecondName(), driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText());
    }
}
