package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import selenium.pageObject.PagePersonalInformation;
import selenium.pageObject.PageShopRegistration;

public class FillPersonalData {
    private static final Logger LOGGER = LogManager.getLogger(
            FillPersonalData.class.getName());
    public static void fillPersonalData(PageShopRegistration page, User user){
       // page.waitForPageLoading(5);
        LOGGER.info("input fields firstName, secondName, sex and password");
        if(user.getSex().getSex().equals("Mr"))page.getPersonInfo().getRadioButtonMr().click();
        if(user.getSex().getSex().equals("Mrs"))page.getPersonInfo().getRadioButtonMrs().click();
        page.getPersonInfo().getFirstName().sendKeys(user.getFirstName());
        page.getPersonInfo().getSecondName().sendKeys(user.getSecondName());
        page.getPersonInfo().getInputEmail().clear();
        page.getPersonInfo().getInputEmail().sendKeys(user.getEmail());
        page.getPersonInfo().getPassword().sendKeys(user.getPassword());

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
    }

    public static void editPersonalInformation(PagePersonalInformation page, User user){
        LOGGER.info("started edit PersonalInformation");
        page.getFirstName().clear();
        page.getSecondName().clear();
        page.getInputEmail().clear();

        LOGGER.info("input fields firstName, secondName, sex and password");
        if(user.getSex().getSex().equals("Mr"))page.getRadioButtonMr().click();
        if(user.getSex().getSex().equals("Mrs"))page.getRadioButtonMrs().click();
        page.getFirstName().sendKeys(user.getFirstName());
        page.getSecondName().sendKeys(user.getSecondName());
        page.getInputEmail().sendKeys(user.getEmail());
        page.getCurrentPassword().sendKeys(user.getPassword());

        LOGGER.info("input birthday's day");
        Select sel = new Select(page.getDayOfBirthday());
        sel.selectByValue(user.getDay());
        sel = new Select(page.getMonthOfBirthday());
        sel.selectByValue(String.valueOf(user.getMonth().ordinal()));
        sel = new Select(page.getYearOfBirthday());
        sel.selectByValue(user.getYear());

        LOGGER.info("click additional button for advertising");
        if(user.isSignUpForOurNewsletter())page.getBtnSignUpForOurNewsletter().click();
        if(user.isReceiveSpecialOffersFromOurPartners())page.getBtnReceiveSpecialOffersFromOurPartners().click();
        page.getBtnSave().click();
    }

}
