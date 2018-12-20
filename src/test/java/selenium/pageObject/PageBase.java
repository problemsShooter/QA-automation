package selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitUntilLoaded() {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }
    public final void waitForPageLoading(int waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);

        wait.until(new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver driver) {
                Boolean pageState;
                try {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    pageState = ((String) executor.executeScript("return document.readyState")).equals("complete");
                } catch (Exception e) {
                    pageState = Boolean.FALSE;
                }
                return pageState;
            }

            @Override
            public String toString() {
                return String.format("custom condition for page load");
            }
        });
    }

    public void click(WebElement element) {
        element.click();
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

}
