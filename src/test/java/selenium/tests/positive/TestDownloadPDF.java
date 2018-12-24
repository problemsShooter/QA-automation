package selenium.tests.positive;

import models.User;
import org.apache.commons.io.FilenameUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.pageObject.PageOrderHistory;
import selenium.pageObject.PageOrderToCard;
import selenium.pageObject.PageShopSignIn;

import java.io.File;

public class TestDownloadPDF extends TestBase {

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @DataProvider(name = "users")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }
    @Test(dataProvider = "users")
    public void testDownloadPDF(User user) throws InterruptedException {
        PageShopSignIn pageShopSignIn = PageShopSignIn.open(driver);
        pageShopSignIn.getInputEmailForSignIn().sendKeys(user.getEmail());
        pageShopSignIn.getPagePersonalInformation().getPassword().sendKeys(user.getPassword());
        pageShopSignIn.getHeaderOfPage().getBtnSignIn().click();
        PageOrderHistory pageOrderHistory = PageOrderHistory.open(driver);
        pageOrderHistory.waitForPageLoaded(driver);
        pageOrderHistory.getBtnDownloadPDF().click();
        Thread.sleep(5000);
        Assert.assertTrue(isFileDownloaded("C:\\Users\\vitaliy.grebnev\\Downloads","IN080109.pdf"));//it's bad, but works

    }
}
