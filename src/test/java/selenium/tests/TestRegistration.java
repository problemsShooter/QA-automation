package selenium.tests;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.data.DataPool;
import selenium.data.DataUsers;
import selenium.pageObject.PageBase;
import selenium.pageObject.PageShop;
import selenium.pageObject.PageShopRegistration;
import selenium.actions.Registration;
import selenium.pageObject.PageShopSignIn;

public class TestRegistration extends TestBase {
    private static final Logger LOGGER = LogManager.getLogger(
            TestRegistration.class.getName());

    @DataProvider(name = "users")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }

    @Test(dataProvider = "users")
    public void verifyUserRegistration(User user) {
        LOGGER.info("Info Message: verifyUserRegistration has been run !!!");
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        LOGGER.info("page ShopSignIn was opened.");
        pageShopSignIn.getPagePersonalInformation().getInputEmail().sendKeys(user.getEmail());
        LOGGER.info("input email address");
        pageShopSignIn.getButtonCreateAnAccount().click();
        LOGGER.info("press button createAnAccount");

        LOGGER.info("page shopRegistration was opened.");
        PageShopRegistration pageShopRegistration = new PageShopRegistration(driver);

        LOGGER.info("input necessary fields for registration");
        Registration.registration(pageShopRegistration, user);

        Assert.assertEquals(user.getFullName(), pageShopSignIn.getHeaderOfPage().getBtnMyAccount().getText(), "verifyTestRegistration is false");
        LOGGER.info("registration finished with success");
    }
}
