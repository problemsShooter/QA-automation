package selenium;

import models.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRegistration extends TestBase {

    @Test(dataProvider = "users", dataProviderClass = DataUsers.class)
    public void verifyUserRegistration(User user) {

    }
}
