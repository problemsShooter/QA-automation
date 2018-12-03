package practice1;

import org.testng.ISuite;
import org.testng.ITestListener;
import org.testng.ITestNGListener;

public class CustomListener implements ITestNGListener {
    //need to add @Override
    public void onStart(ISuite iSuite){
        System.out.println("ISuiteListener#onStart method is invoked");
    }

    public void onFinish(){
        System.out.println("ISuiteListener#onFinish method is invoked");
    }
}
