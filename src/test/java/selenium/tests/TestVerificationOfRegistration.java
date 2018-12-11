package selenium.tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.actions.CheckVerification;
import selenium.data.DataUsers;
import selenium.pageObject.PageShopRegistration;

public class TestVerificationOfRegistration extends TestBase{

    @Test(dataProvider = "users", dataProviderClass = DataUsers.class)
    public void testVerificationOfRegistration(User user) {
        //PageShopRegistration page = PageShopRegistration.open(driver);
        //Assert.assertEquals(CheckVerification.checkMyPersonalInformation(page,user));

    }
}
