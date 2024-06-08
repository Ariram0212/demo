package shopperstack.listner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseClass;

public class ListnerImplementor extends BaseClass implements ISuiteListener,ITestListener {
	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName()+" has Successfully Executed", true);
	}
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" TestScript has Successfully Started", true);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" TestScript has Successfully Skipped", true);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" TestScript has Successfully Ended", true);
	}
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" has Successfully captured SS", true);
		TakesScreenshot takeSs=(TakesScreenshot)driver;
		File ss=takeSs.getScreenshotAs(OutputType.FILE);
		File path=new File("./FailedScreenshot/"+result.getName()+".png");
		try {
			FileHandler.copy(ss, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
