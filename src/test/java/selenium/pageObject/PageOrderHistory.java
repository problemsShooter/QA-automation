package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
@Data
public class PageOrderHistory extends PageBase {

    @FindBy(how = How.XPATH, using = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/span")
    private WebElement btnShowPDF;
    @FindBy(how = How.XPATH, using = "//*[@id=\"order-list\"]/tbody/tr[1]/td[6]/a")
    private WebElement btnDownloadPDF;

    public static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.gettingValuePropertyByKey("orderHistory");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PageOrderHistory open (WebDriver driver){
        driver.navigate().to(baseUrl);
        return new PageOrderHistory(driver);
    }

    public PageOrderHistory(WebDriver driver) {
        super(driver);
    }
}
