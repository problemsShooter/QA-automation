package selenium.pageObject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
@Data
public class PagePersonalAddress extends PageBase{

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[1]")
    private WebElement firstName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[2]")
    private WebElement secondName;




    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[3]/span")
    private WebElement company;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[4]/span[1]")
    private WebElement address;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[4]/span[2]")
    private WebElement additionalAddress;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[1]")
    private WebElement city;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[2]")
    private WebElement state;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[3]")
    private WebElement postalCod;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[6]/span")
    private WebElement country;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[7]/span")
    private WebElement homePhone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[8]/span")
    private WebElement mobillePhone;

    public PagePersonalAddress(WebDriver driver) {
        super(driver);
    }


}
