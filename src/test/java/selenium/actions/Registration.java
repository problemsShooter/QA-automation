package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import selenium.pageObject.PageShopRegistration;

public final class Registration {
    private static final Logger LOGGER = LogManager.getLogger(
            Registration.class.getName());
    public static void registration(PageShopRegistration page, User user) {

        page.waitUntilLoaded();
        LOGGER.info("input fields firstName, secondName, sex and password");
        if(user.getSex().getSex().equals("Mr"))page.getPersonInfo().getRadioButtonMr().click();
        if(user.getSex().getSex().equals("Mrs"))page.getPersonInfo().getRadioButtonMrs().click();
        page.getPersonInfo().getFirstName().sendKeys(user.getFirstName());
        page.getPersonInfo().getSecondName().sendKeys(user.getSecondName());
        page.getPersonInfo().getPassword().sendKeys(user.getPassword());
        //input birthday's day
        LOGGER.info("input birthday's day");
        Select sel = new Select(page.getPersonInfo().getDayOfBirthday());
        sel.selectByValue(user.getDay());
        sel = new Select(page.getPersonInfo().getMonthOfBirthday());
        sel.selectByValue(String.valueOf(user.getMonth().ordinal()));
        sel = new Select(page.getPersonInfo().getYearOfBirthday());
        sel.selectByValue(user.getYear());

        LOGGER.info("click additional button for advertising");
        if(user.isSignUpForOurNewsletter())page.getPersonInfo().getBtnSignUpForOurNewsletter().click();
        if(user.isReceiveSpecialOffersFromOurPartners())page.getPersonInfo().getBtnReceiveSpecialOffersFromOurPartners().click();
        LOGGER.info("input phone address and other fields");
        page.getAddress().sendKeys(user.getAddress());
        page.getAdditionalAddress().sendKeys(user.getAdditionalAddress());
        page.getCity().sendKeys(user.getCity());
        sel = new Select(page.getState());
        sel.selectByValue(String.valueOf(user.getState().ordinal()));

        page.getPostalCod().sendKeys(user.getPostalCod());
        sel = new Select(page.getCountry());
        sel.selectByValue(String.valueOf(user.getCountry().ordinal()+20));//so strange number on a the site's page
        page.getAdditionalInformation().sendKeys(user.getAdditionalInformation());
        page.getHomePhone().sendKeys(user.getHomePhone());
        page.getMobillePhone().sendKeys(user.getMobilPhone());
        page.getAsignAddress().sendKeys(user.getAssignAnAddressAliasForFutureReference());
        page.getCompany().sendKeys(user.getCompany());
        page.getButtonRegister().click();

    }
}
