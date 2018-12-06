package selenium;

import models.User;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataUsers extends TestBase{
    @DataProvider(name = "verifyUsersCreated")
    public static Object[][] verifyUsersCreated() {//we need take it from store file.
        return new Object[][]{
                {User.SEX.MRS, "Marina", "Popova"},
                {User.SEX.MRS, "Elena", "Popova"},
                {User.SEX.MR, "Serge", "Nikitin"}
        };
    }
    @Test(dataProvider = "verifyUsersCreated")
    public void createdUsers(final User.SEX sex, final String firstName, final String secondName) {
        //--------------||test1||--------------------
        //User user = new User(sex, firstName, secondName);
        //Assert.assertNotNull(user);

        //--------------||test2||--------------------
//        PageShopRegistration pageShopRegistration = PageFactory.initElements(driver,PageShopRegistration.class);
//        pageShopRegistration.waitUntilPageLoaded();

    }

    @DataProvider(name = "users")
    public static Object[] createdUsers() {
        return new Object[]{
                new User(User.SEX.MRS, "Marina", "Popova"),
                new User(User.SEX.MRS, "Elena", "Popova"),
                new User(User.SEX.MR, "Serge", "Nikitin")
        };
    }

}
