package selenium.tests;

import models.User;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.data.DataPool;

public class TestCreateListUsers extends TestBase {

    @Test(/*dataProvider = "dataProvider", dataProviderClass = TestCreateListUsers.class*/)
    @Parameters("dataFile")
    public void testJsonToModelConversion(String filePath) throws JSONException {

        DataPool<User> users = new DataPool<User>(User.class);
        users.processDataFile(new User(),filePath,"users");
        System.out.println(users.getCollection());
    }

    @DataProvider(name = "users")
    private Object[] dataProvider(){
        return dataUsersPool.getData();
    }

    @Test( dataProvider = "users" )
    public void testGetAccountFromDataFile( User user ) {


    }
}
