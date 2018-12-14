package selenium.pageObject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
@Data
public class PageShopRegistration extends PageShop{

    //private HeaderOfPage headerOfPage


    private PagePersonalInformation personInfo = new PagePersonalInformation(driver);


    @FindBy(how = How.XPATH, using = "//*[@id=\"address1\"]")
    private WebElement address;
    @FindBy(how = How.XPATH, using = "//*[@id=\"address2\"]")
    private WebElement additionalAddress;
    @FindBy(how = How.XPATH, using = "//*[@id=\"company\"]")
    private WebElement company;
    @FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
    private WebElement city;
    @FindBy(how = How.XPATH, using = "//*[@id=\"id_state\"]")
    private WebElement state;
    @FindBy(how = How.XPATH, using = "//*[@id=\"postcode\"]")
    private WebElement postalCod;
    @FindBy(how = How.XPATH, using = "//*[@id=\"id_country\"]")
    private WebElement country;
    @FindBy(how = How.XPATH, using = "//*[@id=\"other\"]")
    private WebElement additionalInformation;
    @FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
    private WebElement homePhone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"phone_mobile\"]")
    private WebElement mobillePhone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"alias\"]")
    private WebElement asignAddress;
    @FindBy(how = How.XPATH, using = "//*[@id=\"submitAccount\"]/span")
    private WebElement buttonRegister;


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
