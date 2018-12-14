package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
@Data
public class PageShopSignIn extends PageShop {

    private HeaderOfPage headerOfPage = new HeaderOfPage(driver);
    private PagePersonalInformation pagePersonalInformation = new PagePersonalInformation(driver);
   /* @FindBy(how = How.XPATH, using = "//*[@id=\"email_create\"]")
    private WebElement inputEmail;
    @FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")
    private WebElement password;*/

    @FindBy(how = How.XPATH, using = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement buttonCreateAnAccount;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    private WebElement btnMyPersonalInformation;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")
    private WebElement btnMyAddress;

    @FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
    private WebElement inputEmailForSignIn;



    public static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.gettingValuePropertyByKey("registrationPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PageShopSignIn(WebDriver driver) {
        super(driver);
    }

    public static PageShopSignIn open(WebDriver driver) {
        driver.navigate().to(baseUrl);
        return new PageShopSignIn(driver);
    }

}
