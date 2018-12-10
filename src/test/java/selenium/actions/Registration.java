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
        if(user.getSex().getSex().equals("Mr"))page.getRadioButtonMr().click();
        if(user.getSex().getSex().equals("Mrs"))page.getRadioButtonMrs().click();
        page.getFirstName().sendKeys(user.getFirstName());
        page.getSecondName().sendKeys(user.getSecondName());
        page.getPassword().sendKeys(user.getPassword());
        //input birthday's day
        LOGGER.info("input birthday's day");
        Select sel = new Select(page.getDayOfBirthday());
        sel.selectByValue(user.getDay());
        sel = new Select(page.getMonthOfBirthday());
        sel.selectByValue(String.valueOf(user.getMonth().ordinal()+1));
        sel = new Select(page.getYearOfBirthday());
        sel.selectByValue(user.getYear());

        LOGGER.info("click additional button for advertising");
        page.getRadioBtnNews().click();
        page.getRadioBtnOptin().click();
        LOGGER.info("input phone address and other fields");
        page.getAddress().sendKeys(user.getAddress());
        page.getAdditionalAddress().sendKeys(user.getAdditionalAddress());
        page.getCity().sendKeys(user.getCity());
        sel = new Select(page.getState());
        sel.selectByValue(String.valueOf(user.getState().ordinal()+1));

        page.getPostalCod().sendKeys(user.getPostalCod());
        page.getAdditionalInformation().sendKeys(user.getAdditionalInformation());
        page.getHomePhone().sendKeys(user.getHomePhone());
        page.getMobillePhone().sendKeys(user.getMobilPhone());
        page.getAsignAddress().sendKeys(user.getCityOfLiving().getCity());
        page.getCompany().sendKeys(user.getCompany());
        page.getButtonRegister().click();

    }
}
