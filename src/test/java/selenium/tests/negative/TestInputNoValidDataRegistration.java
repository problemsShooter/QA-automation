package selenium.tests.negative;

import models.User;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.actions.ClearPersonalData;
import selenium.actions.Registration;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;
import selenium.tests.TestBase;

public class TestInputNoValidDataRegistration extends TestBase {
    @DataProvider(name = "users")
    private Object[] dataProvider() {
        return dataUsersPool.getData();
    }

    private boolean isTextPresent(String text1, String text2) {
        try {

            return driver.getPageSource().contains(text1) && driver.getPageSource().contains(text2);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTextPresent(String text1) {
        try {

            return driver.getPageSource().contains(text1);
        } catch (Exception e) {
            return false;
        }
    }

    @Test(dataProvider = "users")
    public void verifyEmptyField(User user) {
        SoftAssert softAssert = new SoftAssert();
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getPagePersonalInformation().getInputEmail().sendKeys(user.getEmail());
        pageShopSignIn.getButtonCreateAnAccount().click();


        PageShopRegistration pageShopRegistration = new PageShopRegistration(driver);
        LOGGER.info("Info Message: verifyFieldFirstNameIsEmpty");


        LOGGER.info("input necessary fields for registration without firstName");
        user.setFirstName("");
        Registration.registration(pageShopRegistration, user);
        softAssert.assertTrue(isTextPresent("firstname", " is required."));
        pageShopRegistration.getPersonInfo().getFirstName().sendKeys("Ser");


        LOGGER.info("input necessary fields for registration without secondName");
        pageShopRegistration.getPersonInfo().getSecondName().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("lastname", " is required."));
        pageShopRegistration.getPersonInfo().getSecondName().sendKeys("Petrov");


       LOGGER.info("input necessary fields for registration without email");
        pageShopRegistration.getPersonInfo().getInputEmail().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("email", " is required."));
        pageShopRegistration.getPersonInfo().getInputEmail().sendKeys("Ivvvdvvvcbvvvvvvcvvvcvvcvvvcvvvvvvvvvvvvvvvvvvvvvv.Iv@mail.ru");

        LOGGER.info("input necessary fields for registration without password");
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("password", " is required."));
        pageShopRegistration.getPersonInfo().getPassword().sendKeys("password");


        LOGGER.info("input necessary fields for registration without address");
        pageShopRegistration.getPersonalAddress().getAddress().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("address", " is required."));
        pageShopRegistration.getPersonalAddress().getAddress().sendKeys("address1");

        LOGGER.info("input necessary fields for registration without city");
        pageShopRegistration.getPersonalAddress().getCity().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("city", " is required."));
        pageShopRegistration.getPersonalAddress().getCity().sendKeys("city");

        LOGGER.info("input necessary fields for registration without any phone");
        pageShopRegistration.getPersonalAddress().getMobilePhone().clear();
        pageShopRegistration.getPersonalAddress().getHomePhone().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("You must register at least one phone number."));
        pageShopRegistration.getPersonalAddress().getMobilePhone().sendKeys("8(999) 666 66 66");

        LOGGER.info("input necessary fields for registration without any postalCode");
        pageShopRegistration.getPersonalAddress().getPostalCod().clear();
        pageShopRegistration.getPersonalAddress().getHomePhone().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
        pageShopRegistration.getPersonalAddress().getPostalCod().sendKeys("56783");

        LOGGER.info("input necessary fields for registration without any alias");
        pageShopRegistration.getPersonalAddress().getAsignAddress().clear();
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("alias", " is required."));
        pageShopRegistration.getPersonalAddress().getAsignAddress().sendKeys("asignAddress");


        softAssert.assertAll();
    }

    @Test(dataProvider = "users")
    public void verifyNotValidData(User user) {
        SoftAssert softAssert = new SoftAssert();
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getPagePersonalInformation().getInputEmail().sendKeys(user.getEmail());
        pageShopSignIn.getButtonCreateAnAccount().click();


        PageShopRegistration pageShopRegistration = new PageShopRegistration(driver);
        LOGGER.info("Info Message: verifyNotValidData");

        LOGGER.info("input necessary fields for registration with not valid PostalCod");
        user.setPostalCod("qwerty");
        Registration.registration(pageShopRegistration, user);
        softAssert.assertTrue(isTextPresent("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
        pageShopRegistration.getPersonalAddress().getPostalCod().clear();
        pageShopRegistration.getPersonalAddress().getPostalCod().sendKeys("56785");

        LOGGER.info("input necessary fields for registration with not valid firstname");
        pageShopRegistration.getPersonInfo().getFirstName().clear();
        pageShopRegistration.getPersonInfo().getFirstName().sendKeys("99999");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("firstname", " is invalid."));
        pageShopRegistration.getPersonInfo().getFirstName().clear();
        pageShopRegistration.getPersonInfo().getFirstName().sendKeys("Ser");

        LOGGER.info("input necessary fields for registration with not valid secondname");
        pageShopRegistration.getPersonInfo().getSecondName().clear();
        pageShopRegistration.getPersonInfo().getSecondName().sendKeys("99999");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("lastname", " is invalid."));
        pageShopRegistration.getPersonInfo().getSecondName().clear();
        pageShopRegistration.getPersonInfo().getSecondName().sendKeys("Petrov");

        LOGGER.info("input necessary fields for registration with not valid password");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys("123");
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("password", " is invalid."));

        LOGGER.info("input necessary fields for registration with not valid mail");
        pageShopRegistration.getPersonInfo().getInputEmail().clear();
        pageShopRegistration.getPersonInfo().getInputEmail().sendKeys("qwewerert");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("email", " is invalid."));
        pageShopRegistration.getPersonInfo().getInputEmail().clear();
        pageShopRegistration.getPersonInfo().getInputEmail().sendKeys("Ivvvvvvcbvvvvvvcvvvcvvcvvvcvvvvvvvvvvvvvvvvvvvvvv.Iv@mail.ru");

        LOGGER.info("input necessary fields for registration with not valid state");
        Select sel;
        sel = new Select(pageShopRegistration.getPersonalAddress().getState());
        sel.selectByVisibleText("-");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("This country requires you to choose a State."));
        sel.selectByValue(String.valueOf(user.getState().ordinal()));

        LOGGER.info("input necessary fields for registration with not valid mobilePhone");
        pageShopRegistration.getPersonalAddress().getMobilePhone().clear();
        pageShopRegistration.getPersonalAddress().getMobilePhone().sendKeys("qwewerert");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys(user.getPassword());
        pageShopRegistration.getButtonRegister().click();
        softAssert.assertTrue(isTextPresent("phone_mobile", " is invalid."));
        pageShopRegistration.getPersonalAddress().getMobilePhone().clear();
        pageShopRegistration.getPersonalAddress().getMobilePhone().sendKeys("8(999) 626 00 00");


        softAssert.assertAll();
    }
}
