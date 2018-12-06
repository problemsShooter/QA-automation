package selenium;

import org.openqa.selenium.WebDriver;

public class PageShopRegistration extends PageShopSignIn {
    public PageShopRegistration(WebDriver driver) {
        super(driver);
    }

    public static String baseUrl = PageShopSignIn.baseUrl + "#account-creation";

    public static PageShopRegistration open (WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PageShopRegistration(driver);
    }
    public String getTitle(){
        return driver.getTitle();
    }
}
