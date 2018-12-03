package practice1;

import org.testng.annotations.*;

public class TestClass2 {
    @BeforeSuite
    public void suiteSetup2() {
        System.out.println("testClass2.suiteSetup2: before suite");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("testClass2: before test");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("testClass2: before class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("testClass2: before method");
    }
    @Test
    public void unitLevel() {
        System.out.println("testClass2: Unit level testing");
    }

}
