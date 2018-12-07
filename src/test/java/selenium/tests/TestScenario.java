package selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pageObject.PageShop;
import selenium.pageObject.PageShopRegistration;
import selenium.pageObject.PageShopSignIn;

public class TestScenario extends TestBase {

    @Test
    public void testShopOpenIndexPage() {
        String expectedTitle = "My Store";
        PageShop pageShop = PageShop.open(driver);
        Assert.assertEquals(expectedTitle, pageShop.getTitle());

    }
    @Test
    public void testOpenShopSignIn(){
        String expectedTitle = "Login - My Store";
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        Assert.assertEquals(expectedTitle, pageShopSignIn.getTitle());
    }
    @Test
    public void testOpenShopRegistration(){
        String expectedTitle = "Login - My Store";
        PageShopRegistration pageShopRegistration = PageShopRegistration.open(driver);
        Assert.assertEquals(expectedTitle, pageShopRegistration.getTitle());
    }
}
