package selenium.pageObject;

import forProperty.GetPropertyValues;
import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
@Data
public class PageShop extends PageBase {


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
