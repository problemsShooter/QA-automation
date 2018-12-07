package selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageBase {
     protected   WebDriver driver;

    public PageBase(WebDriver driver) {
        //PageFactory.initElements(driver, PageShopSignIn.class);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void waitUntilLoaded(){
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public void click(WebElement element){
        element.click();
    }

    public void writeText(By elementLocation, String text){
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation){
        return driver.findElement(elementLocation).getText();
    }

}
