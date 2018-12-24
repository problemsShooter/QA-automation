package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageObject.PagePersonalAddress;
import selenium.pageObject.PagePersonalInformation;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;

public class CheckVerification {
    private static final Logger LOGGER = LogManager.getLogger(
            CheckVerification.class.getName());

    public CheckVerification() {
    }

    public SoftAssert checkMyPersonalInformation(PagePersonalInformation page, User user) {
        LOGGER.info("started check PersonalInformation");
        SoftAssert softAssert = new SoftAssert();

        LOGGER.info("check sex, firstName, secondName and Email");
        softAssert.assertEquals(page.getRadioButtonMr().isSelected(), user.getSex().getSex().equals("Mr"));
        softAssert.assertEquals(page.getRadioButtonMrs().isSelected(), user.getSex().getSex().equals("Mrs"));
        softAssert.assertEquals(page.getFirstName().getAttribute("value"), user.getFirstName());
        softAssert.assertEquals(page.getSecondName().getAttribute("value"), user.getSecondName());
        softAssert.assertEquals(page.getInputEmail().getAttribute("value"), user.getEmail());

        LOGGER.info("check birthday's day");
        softAssert.assertEquals(page.getDayOfBirthday().getAttribute("value"), user.getDay());
        softAssert.assertEquals(page.getMonthOfBirthday().getAttribute("value"), String.valueOf(user.getMonth().ordinal()));
        softAssert.assertEquals(page.getYearOfBirthday().getAttribute("value"), user.getYear());
        return softAssert;
    }
    public SoftAssert checkMyPersonalAddress(PagePersonalAddress page, User user) {
        LOGGER.info("started check PersonalAddress");
        SoftAssert softAssert = new SoftAssert();
        LOGGER.info("check address and additional address");
        softAssert.assertEquals(page.getAddress().getAttribute("value"),user.getAddress());
        softAssert.assertEquals(page.getAdditionalAddress().getAttribute("value"),user.getAdditionalAddress());

        LOGGER.info("check city, state and postcode");
        softAssert.assertEquals(page.getCity().getAttribute("value"),user.getCity());
        softAssert.assertEquals(page.getState().getAttribute("value"),String.valueOf(user.getState().ordinal()));
        softAssert.assertEquals(page.getPostalCod().getAttribute("value"),user.getPostalCod());

        LOGGER.info("check country, homePhone, mobilePhone");
        softAssert.assertEquals(page.getCountry().getAttribute("value"),String.valueOf(user.getCountry().ordinal()+20));
        softAssert.assertEquals(page.getHomePhone().getAttribute("value"),user.getHomePhone());
        softAssert.assertEquals(page.getMobilePhone().getAttribute("value"),user.getMobilPhone());

        return softAssert;
    }
}
