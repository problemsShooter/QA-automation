package selenium.tests.pageElementsVerification;

import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;
import selenium.tests.positive.TestBase;

public class TestElementVerificationPageRegistration extends TestBase {

    @DataProvider(name="users")
    public Object[] dataProvider(){
        return dataUsersPool.getData();
    }

    @Test(dataProvider = "users")
    public void testElementVerificationPageRegistration(User user) {

        LOGGER.info("go to PageRegistration");
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        //pageShopSignIn.waitForPageLoading(5);
        pageShopSignIn.getPagePersonalInformation().getInputEmail().sendKeys(user.getEmail());
        pageShopSignIn.getButtonCreateAnAccount().click();

        PageShopRegistration pageShopRegistration = new PageShopRegistration(driver);
        pageShopRegistration.waitForPageLoading(60);
        SoftAssert softAssert = new SoftAssert();

        LOGGER.info("verify personalInfo");
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getRadioButtonMr().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getRadioButtonMrs().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getFirstName().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getSecondName().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getInputEmail().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getPassword().isDisplayed());

        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getDayOfBirthday().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getMonthOfBirthday().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getYearOfBirthday().isDisplayed());

        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getBtnSignUpForOurNewsletter().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getBtnReceiveSpecialOffersFromOurPartners().isDisplayed());

        LOGGER.info("verify personalAddress");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getCompany().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAddress().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAdditionalAddress().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getCity().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getState().isEnabled());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getPostalCod().isEnabled());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getCountry().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAdditionalInformation().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getHomePhone().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getMobilePhone().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAsignAddress().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getButtonRegister().isDisplayed());

        softAssert.assertAll();
    }
}
