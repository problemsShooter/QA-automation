package selenium.pageObject;

import forProperty.GetPropertyValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class PageShopSignIn extends PageShop {

    @FindBy(how = How.XPATH,using = "//*[@id=\"email_create\"]")
            private WebElement inputEmail;
    @FindBy(how = How.XPATH,using = "//*[@id=\"SubmitCreate\"]/span")
            private WebElement buttonCreateAnAccount;

    public static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.getPropertyValue() + "?controller=authentication&back=my-account";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PageShopSignIn(WebDriver driver){
        super(driver);
    }

    public static PageShopSignIn open(WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PageShopSignIn(driver);
    }
//    @Test
//    public void simpleTest() {
//        PageShopSignIn pageShopSignIn = PageFactory.initElements( super.driver,PageShopSignIn.class);
//        pageShopSignIn.
//        inputEmail.sendKeys("qweqaz@mail.ru");
//        buttonCreateAnAccount.click();
//        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1")));
//    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(WebElement inputEmail) {
        this.inputEmail = inputEmail;
    }

    public WebElement getButtonCreateAnAccount() {
        return buttonCreateAnAccount;
    }

    public void setButtonCreateAnAccount(WebElement buttonCreateAnAccount) {
        this.buttonCreateAnAccount = buttonCreateAnAccount;
    }
}
