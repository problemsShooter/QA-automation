package selenium.tests.placingInOrder;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.pageObject.PageOrderToCard;
import selenium.pageObject.PageShop;
import selenium.pageObject.PageShopSignIn;
import selenium.tests.positive.TestBase;

public class TestPlacingAnOrderToAccount extends TestBase {

    @DataProvider(name = "users")
    public Object[] dataProvider() {
        return dataUsersPool.getData();
    }

    private String getReferenceOrder(String line) {//getting of ling new order
        return line.replaceAll("(.*\\n)*.*([A-Z]{9}).*\\n(.*\\n)*.*","$2");
    }

    @Test(dataProvider = "users")
    public void placingAnOrderToAccount(User user) {
        LOGGER.info("log in Users");
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getInputEmailForSignIn().sendKeys(user.getEmail());
        pageShopSignIn.getInputPassword().sendKeys(user.getPassword());
        pageShopSignIn.getBtnSignIn().click();
        PageShop pageShop = new PageShop(driver);
        pageShop.waitUntilPageLoaded();
        LOGGER.info("make out an order");
        pageShop.getBtnWomen().click();
        PageOrderToCard pageOrderToCard = new PageOrderToCard(driver);
        pageOrderToCard.waitForPageLoading(5);
        pageOrderToCard.getBtnAddBlouseToCard().click();
        pageOrderToCard.getBtnProceedToCheckOutFirst().click();
        pageOrderToCard.getBtnProceedToCheckOutSecond().click();
        pageOrderToCard.getBtnProceedToCheckOutThird().click();
        pageOrderToCard.getRadioBtnAgreeWithService().click();
        pageOrderToCard.getBtnProceedToCheckOutFourth().click();
        pageOrderToCard.getBtnPayByBankWire().click();
        pageOrderToCard.getBtnIConfirmMyOrder().click();


        String link = getReferenceOrder(pageOrderToCard.getReferenceToOrder().getText());
        LOGGER.info("got link of new order");
        pageOrderToCard.getBtnBackToOrders().click();
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(link), "Text not found!");

    }
}
