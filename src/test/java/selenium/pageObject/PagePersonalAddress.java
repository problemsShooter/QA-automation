package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

@Data
public class PagePersonalAddress extends PageBase{

    @FindBy(how = How.XPATH, using = "//*[contains(@id,'address1')]")
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
    private WebElement mobilePhone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]/span")
    private WebElement btnUpdate;
    @FindBy(how = How.XPATH, using = "//*[@id=\"alias\"]")
    private WebElement asignAddress;
    @FindBy(how = How.XPATH, using = "//*[@id=\"submitAddress\"]/span")
    private WebElement btnSave;
    @FindBy(how = How.XPATH, using = "//*[@id=\"submitAddress\"]/span")
    private WebElement btnBackToYourAddresses;

    public PagePersonalAddress(WebDriver driver) {
        super(driver);
    }
    public static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.gettingValuePropertyByKey("myPersonalAddressPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static PagePersonalInformation open (WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PagePersonalInformation(driver);
    }
}
