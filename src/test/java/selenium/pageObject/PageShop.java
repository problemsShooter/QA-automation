package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
@Data
public class PageShop extends PageBase {

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement btnWomen;

    private static String baseUrl;

    static {
        try {
            baseUrl = GetPropertyValues.gettingValuePropertyByKey("relativePath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PageShop(WebDriver driver) {
        super(driver);
    }

    public static PageShop open(WebDriver driver) {
        driver.navigate().to(baseUrl);
        return new PageShop(driver);
    }

    public void waitUntilPageLoaded() {
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
