package selenium.tests;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.actions.CheckVerification;
import selenium.pageObject.PagePersonalAddress;
import selenium.pageObject.PagePersonalInformation;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;

public class TestAccountData extends TestBase{
    private static final Logger LOGGER = LogManager.getLogger(
            TestAccountData.class.getName());

    @DataProvider(name = "users")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }

    @Test(dataProvider = "users")
    public void verifyUserAccountData(User user){
        LOGGER.info("Started verify registration");
        PageShopSignIn page = PageShopSignIn.open(driver);
        page.waitUntilLoaded();
        page.getInputEmailForSignIn().sendKeys(user.getEmail());
        page.getPagePersonalInformation().getPassword().sendKeys(user.getPassword());
        page.getHeaderOfPage().getBtnSignIn().click();
        LOGGER.info("Entered email and password and signIn into account");

        page.getBtnMyPersonalInformation().click();
        PagePersonalInformation pagePersonalInformation = new PagePersonalInformation(driver);
        pagePersonalInformation.waitUntilLoaded();
        CheckVerification.checkMyPersonalInformation(pagePersonalInformation,user).assertAll();

        pagePersonalInformation.getBtnToYourAccount().click();

        page.getBtnMyAddress().click();

        PagePersonalAddress pagePersonalAddress = new PagePersonalAddress(driver);

        CheckVerification.checkMyPersonalAddress(pagePersonalAddress, user).assertAll();


    }
}
