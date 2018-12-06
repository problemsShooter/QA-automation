package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageShopSignIn extends PageShop{

    @FindBy(how = How.XPATH,using = "//*[@id=\"email_create\"]")
            public WebElement inputEmail;
    @FindBy(how = How.XPATH,using = "//*[@id=\"SubmitCreate\"]/span")
            private WebElement buttonCreateAnAccount;

    PageShopSignIn(WebDriver driver){
        super(driver);
    }
    public static String baseUrl = PageShop.baseUrl + "?controller=authentication&back=my-account";

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
