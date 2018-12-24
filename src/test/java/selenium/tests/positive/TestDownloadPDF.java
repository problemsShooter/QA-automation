package selenium.tests.positive;

import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.pageObject.PageOrderHistory;
import selenium.pageObject.PageOrderToCard;
import selenium.pageObject.PageShopSignIn;

public class TestDownloadPDF extends TestBase {
    @DataProvider(name = "users")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }
    @Test(dataProvider = "users")
    public void testDownloadPDF(User user){
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getInputEmailForSignIn().sendKeys(user.getEmail());
        pageShopSignIn.getPagePersonalInformation().getPassword().sendKeys(user.getPassword());
        pageShopSignIn.getHeaderOfPage().getBtnSignIn().click();
        PageOrderHistory pageOrderHistory = PageOrderHistory.open(driver);
        pageOrderHistory.waitSuccessfulMessage(driver,pageOrderHistory.getBtnShowPDF());
        pageOrderHistory.getBtnShowPDF().click();
        //driver.switchTo().window(pageOrderHistory.getBtnDownloadPDF().getAttribute("href"));
        driver.get(pageOrderHistory.getBtnDownloadPDF().getAttribute("href"));
    }
}
