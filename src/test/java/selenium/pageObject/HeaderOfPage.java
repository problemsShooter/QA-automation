package selenium.pageObject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
@Data
public class HeaderOfPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    private WebElement btnMyAccount;
    @FindBy(how = How.XPATH, using = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement btnSignIn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")//it may does't work
    private WebElement btnSignOut;

    public HeaderOfPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
