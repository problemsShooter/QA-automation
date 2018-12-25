package selenium.tests.pageElementsVerification;

import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.pageObject.HeaderOfPage;
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
        pageShopSignIn.getPagePersonalInformation().getInputEmail().sendKeys(user.getEmail());
        pageShopSignIn.getButtonCreateAnAccount().click();

        PageShopRegistration pageShopRegistration = new PageShopRegistration(driver);
        pageShopRegistration.waitSuccessfulMessage(driver,pageShopRegistration.getPersonInfo().getRadioButtonMr());
        pageShopRegistration.waitForPageLoaded(driver);
        SoftAssert softAssert = new SoftAssert();

        LOGGER.info("verify personalInfo");
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getRadioButtonMr().isDisplayed(),"Mr isn't displayed");
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getRadioButtonMrs().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getFirstName().isDisplayed(),"7");
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getSecondName().isDisplayed(),"8");
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getInputEmail().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getPassword().isDisplayed(),"9");

        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getDayOfBirthday().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getMonthOfBirthday().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getYearOfBirthday().isDisplayed(),"10");

        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getBtnSignUpForOurNewsletter().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonInfo().getBtnReceiveSpecialOffersFromOurPartners().isDisplayed());

        LOGGER.info("verify personalAddress");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getCompany().isDisplayed(),"Company is not displayed");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAddress().isDisplayed(),"1");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAdditionalAddress().isDisplayed(),"2");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getCity().isDisplayed(),"3");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getState().isEnabled(),"4");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getPostalCod().isEnabled());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getCountry().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAdditionalInformation().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getHomePhone().isDisplayed(),"5");
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getMobilePhone().isDisplayed());
        softAssert.assertTrue(pageShopRegistration.getPersonalAddress().getAsignAddress().isDisplayed(),"6");
        softAssert.assertTrue(pageShopRegistration.getButtonRegister().isDisplayed());

        /*HeaderOfPage headerOfPage = new HeaderOfPage(driver);
        headerOfPage.getBtnSignOut().click();
        pageShopSignIn.waitForPageLoaded(driver);*/

        softAssert.assertAll();

    }
}
