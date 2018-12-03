package practice1;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListener.class)
public class Task1 {


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("\nTest1.BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test1.BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test1.BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Test1.BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test1.AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Test1.AfterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test1.AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test1.AfterSuite");
    }

    @Test
    @Parameters({"firstNumber"})
    public void method(int i) {
        if (i > 0) {
            System.out.println("Method has failed");
            Assert.fail();
        }
    }

    @DataProvider(name = "someDataForEquals")
    public Object[][] simpleDataProvider1() {
        return new Object[][]{
                {new Double(1), Math.pow(1, 2)},
                {new Double(2), Math.sqrt(4)},
                {new Double(5), new Double(Math.abs(-5))},
        };
    }

    @DataProvider(name = "someDataForNotEquals")
    public Object[][] simpleDataProvider2() {
        return new Object[][]{
                {new Double(5), Math.pow(1, 2)},
                {new Double(3), Math.sqrt(4)},
                {new Double(1), new Double(Math.abs(-5))},
        };
    }

    @Test(dataProvider = "someDataForEquals", dependsOnMethods = "method")
        public void simpleTestEquals(Double i, Double j) {
        Assert.assertEquals(i, j, "Provided numbers are not equals");

    }

    @Test(groups = "math", dataProvider = "someDataForNotEquals")
    public void simpleTestNotEquals(Double i, Double j) {
        Assert.assertNotEquals(i, j, "Provided numbers are not equals");

    }

    @Test(groups = "math", dataProvider = "someDataForEquals")
    public void simpleTestAssertTrue(Double i, Double j) {
        Assert.assertTrue(i.equals(j), "Provided numbers are not equals");

    }

    @Test(groups = "math", dataProvider = "someDataForNotEquals")
    public void simpleTestAssertFalse(Double i, Double j) {
        Assert.assertFalse(i.equals(j), "Provided numbers are not equals");
    }

    @DataProvider(name = "dataForSoftTest")
    public Object[][] dataForSoftTest() {
        return new Object[][]{
                {new Double(2), new Double(Math.sqrt(9))},
                {new Double(1), new Double(Math.sqrt(1))},
                {new Double(3), new Double(Math.sqrt(10))},
                {new Double(4), new Double(Math.sqrt(16))}
        };
    }

    @Test(dataProvider = "dataForSoftTest")
    public void simpleSoftTest(Double i, Double j) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(i, j);
        softAssert.assertAll();
    }

    @Test(groups = "math")
    @Parameters({"firstNumber", "secondNumber"})
    public void simpleParametrisedTest(int i, int j) {
        Assert.assertEquals(i, j, "Provided numbers are not equals");
    }


}
