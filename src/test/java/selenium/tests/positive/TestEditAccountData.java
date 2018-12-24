package selenium.tests.positive;

import io.qameta.allure.Step;
import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.actions.EditDataUsers;
import selenium.pageObject.*;

public class TestEditAccountData extends TestBase{

    @DataProvider(name = "usersForEditData")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }

    @Test(dataProvider = "usersForEditData", description = "Edit account Data" )
    @Step( "Verify edit account Data." )
    public void testEditAccountData(User user) {
        LOGGER.info("Started edit data");
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getInputEmailForSignIn().sendKeys(user.getEmail());
        pageShopSignIn.getPagePersonalInformation().getPassword().sendKeys(user.getPassword());
        pageShopSignIn.getHeaderOfPage().getBtnSignIn().click();
        LOGGER.info("Entered email and password and signIn into account");

        pageShopSignIn.getBtnMyPersonalInformation().click();
        PagePersonalInformation pagePersonalInformation = new PagePersonalInformation(driver);

        EditDataUsers editDataUsers = new EditDataUsers();

        editDataUsers.editPersonalInfo(pagePersonalInformation, user);
        pagePersonalInformation.getBtnToYourAccount().click();
        pageShopSignIn.getBtnMyAddress().click();

        PagePersonalAddress pagePersonalAddress = new PagePersonalAddress(driver);
        pagePersonalAddress.getBtnUpdate().click();
        editDataUsers.editPersonalAddress(pagePersonalAddress,user);
        HeaderOfPage headerOfPage = new HeaderOfPage(driver);
        headerOfPage.getBtnSignOut().click();
       //pageShopSignIn.waitForPageLoaded(driver);

    }
}
