package selenium.tests.negativeAccountRegistration;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.actions.Registration;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;
import selenium.tests.positive.TestBase;

import java.util.List;

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

    @Test(dataProvider = "users",description = "Edit Account Negative Test")
    @Step( "Update Account with invalid values and verify errors" )
    public void verifyNotValidData(User user) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getPagePersonalInformation().getInputEmail().sendKeys(user.getEmail());
        pageShopSignIn.getButtonCreateAnAccount().click();

        PageShopRegistration pageShopRegistration = PageShopRegistration.open(driver);
        LOGGER.info("Info Message: verifyFieldFirstNameIsEmpty");
        pageShopRegistration.waitSuccessfulMessage(driver, pageShopRegistration.getPersonInfo().getRadioButtonMr());
//pageShopRegistration.waitForPageLoading(10);
        Registration registration = new Registration();

        registration.registration(pageShopRegistration, user);

        List<WebElement> errors = driver.findElements(By.xpath("//*[contains(@id,'center_column')]/div/ol/li"));
        softAssert.assertTrue(isTextPresent("error"));

        softAssert.assertEquals("You must register at least one phone number.", errors.get(0).getText());
        softAssert.assertEquals("lastname is required.", errors.get(1).getText());
        softAssert.assertEquals("firstname is required.", errors.get(2).getText());
        softAssert.assertEquals("passwd is required.", errors.get(3).getText());
        softAssert.assertEquals("alias is required.", errors.get(4).getText());
        softAssert.assertEquals("address1 is required.", errors.get(5).getText());
        softAssert.assertEquals("city is required.", errors.get(6).getText());
        softAssert.assertEquals("The Zip/Postal code you've entered is invalid. It must follow this format: 00000", errors.get(7).getText());
        softAssert.assertEquals("This country requires you to choose a State.", errors.get(8).getText());

        Select sel;
        pageShopRegistration.getPersonInfo().getFirstName().sendKeys("99999");
        pageShopRegistration.getPersonInfo().getSecondName().sendKeys("99999");
        pageShopRegistration.getPersonInfo().getPassword().sendKeys("123");
        pageShopRegistration.getPersonalAddress().getAsignAddress().sendKeys("qweqw");
        pageShopRegistration.getPersonalAddress().getAddress().sendKeys("qweqw");
        pageShopRegistration.getPersonInfo().getInputEmail().clear();
        pageShopRegistration.getPersonInfo().getInputEmail().sendKeys("qwewerert");
        pageShopRegistration.getPersonalAddress().getMobilePhone().sendKeys("qwewerert");
        pageShopRegistration.getPersonalAddress().getPostalCod().sendKeys("67543");
        sel = new Select(pageShopRegistration.getPersonalAddress().getCountry());
        sel.selectByValue(String.valueOf(user.getCountry().ordinal() + 20));//so strange number on a the site's page

        sel = new Select(pageShopRegistration.getPersonalAddress().getState());
        sel.selectByValue(String.valueOf(3));

        errors.clear();
        pageShopRegistration.getButtonRegister().click();
        errors = driver.findElements(By.xpath("//*[contains(@id,'center_column')]/div/ol/li"));
        softAssert.assertEquals("lastname is invalid.",errors.get(0).getText());
        softAssert.assertEquals("firstname is invalid.",errors.get(1).getText());
        softAssert.assertEquals("email is invalid.",errors.get(2).getText());
        softAssert.assertEquals("passwd is invalid.",errors.get(3).getText());
        softAssert.assertEquals("phone_mobile is invalid.",errors.get(5).getText());

        softAssert.assertAll();
    }

}
