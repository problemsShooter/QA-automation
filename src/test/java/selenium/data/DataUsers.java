package selenium.data;

import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.tests.TestBase;

public class DataUsers {
    @DataProvider(name = "verifyUsersCreated")
    public static Object[][] verifyUsersCreated() {//we need take it from store file.
        return new Object[][]{
                {User.SEX.MRS, "Marina", "Popova"},
                {User.SEX.MRS, "Elena", "Popova"},
                {User.SEX.MR, "Serge", "Nikitin"}
        };
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
