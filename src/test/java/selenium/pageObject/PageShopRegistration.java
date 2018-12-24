package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

@Data
public class PageShopRegistration extends PageBase{

    private HeaderOfPage headerOfPage = new HeaderOfPage(driver);
    private PagePersonalInformation personInfo = new PagePersonalInformation(driver);
    private PagePersonalAddress personalAddress = new PagePersonalAddress(driver);

    @FindBy(how = How.XPATH, using = "//*[@id=\"submitAccount\"]/span")
    private WebElement buttonRegister;

    public PageShopRegistration(WebDriver driver) {
        super(driver);
    }

    public static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.gettingValuePropertyByKey("registrationPagePath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static PageShopRegistration open (WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PageShopRegistration(driver);
    }
    public String getTitle(){
        return driver.getTitle();
    }

}
