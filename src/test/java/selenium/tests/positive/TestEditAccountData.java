package selenium.tests.positive;

import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.actions.EditDataUsers;
import selenium.pageObject.PagePersonalAddress;
import selenium.pageObject.PagePersonalInformation;
import selenium.pageObject.PageShopSignIn;

public class TestEditAccountData extends TestBase{

    @DataProvider(name = "usersForEditData")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }

    @Test(dataProvider = "usersForEditData")
    public void testEditAccountData(User user) {
        LOGGER.info("Started edit data");
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.waitForPageLoading(5);
        pageShopSignIn.getInputEmailForSignIn().sendKeys(user.getEmail());
        pageShopSignIn.getPagePersonalInformation().getPassword().sendKeys(user.getPassword());
        pageShopSignIn.getHeaderOfPage().getBtnSignIn().click();
        LOGGER.info("Entered email and password and signIn into account");

        pageShopSignIn.getBtnMyPersonalInformation().click();
        PagePersonalInformation pagePersonalInformation = new PagePersonalInformation(driver);
        pagePersonalInformation.waitForPageLoading(5);

        EditDataUsers.editPersonalInfo(pagePersonalInformation, user);
        pagePersonalInformation.getBtnToYourAccount().click();
        pageShopSignIn.getBtnMyAddress().click();

        PagePersonalAddress pagePersonalAddress = new PagePersonalAddress(driver);
        pagePersonalAddress.getBtnUpdate().click();
        pagePersonalAddress.waitForPageLoading(5);
        EditDataUsers.editPersonalAddress(pagePersonalAddress,user);


    }
}
