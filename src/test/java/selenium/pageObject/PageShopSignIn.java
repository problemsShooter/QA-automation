package selenium.pageObject;

import forProperty.GetPropertyValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class PageShopSignIn extends PageShop {

    @FindBy(how = How.XPATH, using = "//*[@id=\"email_create\"]")
    private WebElement inputEmail;
    @FindBy(how = How.XPATH, using = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement buttonCreateAnAccount;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    private WebElement btnMyAccount;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement btnSignOut;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    private WebElement btnMyPersonalInformation;

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

    public WebElement getInputEmail() {
        return inputEmail;
    }


    public WebElement getButtonCreateAnAccount() {
        return buttonCreateAnAccount;
    }

    public WebElement getBtnMyAccount() {
        return btnMyAccount;
    }

    public WebElement getBtnSignOut() {
        return btnSignOut;
    }
}
