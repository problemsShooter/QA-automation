package selenium.pageObject;

import forProperty.GetPropertyValues;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageShop extends PageBase {
     private static String baseUrl;
    static {
        try {
            baseUrl = GetPropertyValues.getPropertyValue();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            baseUrl="http://automationpractice.com";
        }
    }

    public PageShop(WebDriver driver){
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
