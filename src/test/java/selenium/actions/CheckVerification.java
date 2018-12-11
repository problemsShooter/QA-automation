package selenium.actions;

import models.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;

public class CheckVerification {

    public static boolean checkMyPersonalInformation(PageShopRegistration page, User user){

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(page.getRadioButtonMr().isSelected(), user.getSex().getSex());
        softAssert.assertEquals(page.getInputEmail(), user.getEmail());
        softAssert.assertAll();
        return true;
    }
}
