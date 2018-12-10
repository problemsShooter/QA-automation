package selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageShopRegistration extends PageShop{

    @FindBy(how = How.XPATH,using = "//*[@id=\"email_create\"]")
    private WebElement inputEmail;
    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender1\"]")
    private WebElement radioButtonMr;
    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender2\"]")
    private WebElement radioButtonMrs;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer_firstname\"]")
    private WebElement firstName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer_lastname\"]")
    private WebElement secondName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@id=\"days\"]")
    private WebElement dayOfBirthday;
    @FindBy(how = How.XPATH, using = "//*[@id=\"months\"]")
    private WebElement monthOfBirthday;
    @FindBy(how = How.XPATH, using = "//*[@id=\"years\"]")
    private WebElement yearOfBirthday;
    @FindBy(how = How.XPATH, using = "//*[@id=\"newsletter\"]")
    private WebElement radioBtnNews;
    @FindBy(how = How.XPATH, using = "//*[@id=\"optin\"]")
    private WebElement radioBtnOptin;
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

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getHomePhone() {
        return homePhone;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getSecondName() {
        return secondName;
    }

    public WebElement getAdditionalInformation() {
        return additionalInformation;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getAdditionalAddress() {
        return additionalAddress;
    }

    public WebElement getDayOfBirthday() {
        return dayOfBirthday;
    }

    public WebElement getMonthOfBirthday() {
        return monthOfBirthday;
    }

    public WebElement getYearOfBirthday() {
        return yearOfBirthday;
    }

    public WebElement getRadioBtnNews() {
        return radioBtnNews;
    }

    public WebElement getRadioBtnOptin() {
        return radioBtnOptin;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getButtonRegister() {
        return buttonRegister;
    }

    public WebElement getAddress() {
        return address;
    }


    public WebElement getCity() {
        return city;
    }

    public WebElement getPostalCod() {
        return postalCod;
    }

    public WebElement getRadioButtonMr() {
        return radioButtonMr;
    }

    public WebElement getRadioButtonMrs() {
        return radioButtonMrs;
    }

    public WebElement getMobillePhone() {
        return mobillePhone;
    }

    public WebElement getAsignAddress() {
        return asignAddress;
    }
}
