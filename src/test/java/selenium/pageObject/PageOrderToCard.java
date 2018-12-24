package selenium.pageObject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
@Data
public class PageOrderToCard extends PageBase{

    public PageOrderToCard(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")
    private WebElement btnAddBlouseToCard;
    @FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement btnProceedToCheckOutFirst;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement btnProceedToCheckOutSecond;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/form/p/button/span")
    private WebElement btnProceedToCheckOutThird;
    @FindBy(how = How.XPATH, using = "//*[@id=\"form\"]/p/button/span")
    private WebElement btnProceedToCheckOutFourth;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cgv\"]")
    private WebElement radioBtnAgreeWithService;
    @FindBy(how = How.XPATH, using = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    private WebElement btnPayByBankWire;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cart_navigation\"]/button/span")
    private WebElement btnIConfirmMyOrder;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div")
    private WebElement referenceToOrder;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p/a")
    private WebElement btnBackToOrders;


}
