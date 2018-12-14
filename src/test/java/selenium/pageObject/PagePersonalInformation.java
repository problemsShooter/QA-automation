package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
@Data
public class PagePersonalInformation extends PageBase {

    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender1\"]")
    private WebElement radioButtonMr;
    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender2\"]")
    private WebElement radioButtonMrs;
    @FindBy(how = How.XPATH,using = "//*[contains(@id,'email')]")
    private WebElement inputEmail;
    @FindBy(how = How.XPATH, using = "//*[contains(@id,'firstname')]")
    private WebElement firstName;
    @FindBy(how = How.XPATH, using = "//*[contains(@id,'lastname')]")
    private WebElement secondName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@id=\"days\"]")
    private WebElement dayOfBirthday;
    @FindBy(how = How.XPATH, using = "//*[@id=\"months\"]")
    private WebElement monthOfBirthday;
    @FindBy(how = How.XPATH, using = "//*[@id=\"years\"]")
    private WebElement yearOfBirthday;
    @FindBy(how = How.XPATH, using = "//*[@id=\"old_passwd\"]")
    private WebElement currentPassword;
    @FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")
    private WebElement newPassword;
    @FindBy(how = How.XPATH, using = "//*[@id=\"confirmation\"]")
    private WebElement confirmationPassword;
    @FindBy(how = How.XPATH, using = "//*[@id=\"newsletter\"]")
    private WebElement btnSignUpForOurNewsletter;
    @FindBy(how = How.XPATH, using = "//*[@id=\"optin\"]")
    private WebElement btnReceiveSpecialOffersFromOurPartners;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li[1]/a/span")
    private WebElement btnToYourAccount;


    public PagePersonalInformation(WebDriver driver){
        super(driver);
    }
    public static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.gettingValuePropertyByKey("myPersonalInfoPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static PagePersonalInformation open (WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PagePersonalInformation(driver);
    }
}
