package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageObject.PagePersonalInformation;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;

public class CheckVerification {
    private static final Logger LOGGER = LogManager.getLogger(
            CheckVerification.class.getName());
    public static boolean checkMyPersonalInformation(PagePersonalInformation page, User user){
        LOGGER.info("started check data");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(page.getRadioButtonMr().isSelected(), user.getSex().getSex().equals("Mr"));
        softAssert.assertEquals(page.getRadioButtonMrs().isSelected(), user.getSex().getSex().equals("Mrs"));
        softAssert.assertEquals(page.getFirstName().getAttribute("value"), user.getFirstName());
        try{softAssert.assertAll();}
        catch(Exception e){
            return false;
        }
        return true;
    }
}
