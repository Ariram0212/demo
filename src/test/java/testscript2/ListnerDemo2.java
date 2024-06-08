package testscript2;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
//@Listeners(shopperstack.listner.ListnerImplementor.class)
public class ListnerDemo2 extends BaseClass{
	@Test(retryAnalyzer = shopperstack.listner.RetryListner.class)
	public void demo()
	{
		//Assert.fail();
		Reporter.log(driver.getTitle(), true);
	}
}
