package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import selenium.pageObject.PagePersonalAddress;
import selenium.pageObject.PagePersonalInformation;
import selenium.pageObject.PageShopRegistration;

public class FillPersonalAddress {
    private static final Logger LOGGER = LogManager.getLogger(
            FillPersonalAddress.class.getName());

    public static void fillPersonalAddress(PageShopRegistration page, User user) {

        LOGGER.info("input phone address and other fields");
        page.getPersonalAddress().getAddress().sendKeys(user.getAddress());
        page.getPersonalAddress().getAdditionalAddress().sendKeys(user.getAdditionalAddress());
        page.getPersonalAddress().getCity().sendKeys(user.getCity());
        Select sel;
        sel = new Select(page.getPersonalAddress().getState());
        sel.selectByValue(String.valueOf(user.getState().ordinal()));

        page.getPersonalAddress().getPostalCod().sendKeys(user.getPostalCod());
        sel = new Select(page.getPersonalAddress().getCountry());
        sel.selectByValue(String.valueOf(user.getCountry().ordinal() + 20));//so strange number on a the site's page
        page.getPersonalAddress().getAdditionalInformation().sendKeys(user.getAdditionalInformation());
        page.getPersonalAddress().getHomePhone().sendKeys(user.getHomePhone());
        page.getPersonalAddress().getMobilePhone().sendKeys(user.getMobilPhone());
        page.getPersonalAddress().getAsignAddress().sendKeys(user.getAssignAnAddressAliasForFutureReference());
        page.getPersonalAddress().getCompany().sendKeys(user.getCompany());
        page.getButtonRegister().click();
    }

    public static void editPersonalAddress(PagePersonalAddress page, User user) {

        LOGGER.info("started edit PersonalAddress");
        page.getAddress().clear();
        page.getAdditionalAddress().clear();
        page.getCompany().clear();
        page.getCity().clear();
        page.getPostalCod().clear();
        page.getAdditionalInformation().clear();
        page.getHomePhone().clear();
        page.getMobilePhone().clear();
        page.getAsignAddress().clear();

        LOGGER.info("input phone and address");
        page.getAddress().sendKeys(user.getAddress());
        page.getAdditionalAddress().sendKeys(user.getAdditionalAddress());
        page.getCity().sendKeys(user.getCity());
        Select sel;
        sel = new Select(page.getState());
        sel.selectByValue(String.valueOf(user.getState().ordinal()));

        final int NUMBER = 20;//so strange number on a the site's page

        page.getPostalCod().sendKeys(user.getPostalCod());
        sel = new Select(page.getCountry());
        sel.selectByValue(String.valueOf(user.getCountry().ordinal() + NUMBER));
        page.getAdditionalInformation().sendKeys(user.getAdditionalInformation());
        page.getHomePhone().sendKeys(user.getHomePhone());
        page.getMobilePhone().sendKeys(user.getMobilPhone());
        page.getAsignAddress().sendKeys(user.getAssignAnAddressAliasForFutureReference());
        page.getCompany().sendKeys(user.getCompany());
        page.getBtnSave().click();

    }
}
