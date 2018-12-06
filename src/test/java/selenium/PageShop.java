package selenium;

import org.openqa.selenium.WebDriver;

public class PageShop extends PageBase {

     static String baseUrl = "http://automationpractice.com";

    public PageShop(WebDriver driver) {
        super(driver);
    }

    public static PageShop open(WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PageShop(driver);
    }

    public void waitUntilPageLoaded(){}

    public String getTitle(){return driver.getTitle();}

    //in demo example there're some other fields and methods
}
