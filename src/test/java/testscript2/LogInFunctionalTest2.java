package testscript2;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import login.LoginUtility;

public class LogInFunctionalTest2 extends BaseClass{
	@DataProvider
	public Object[][] dataSupplier()
	{
		LoginUtility readData=new LoginUtility();
		Object[][] data=readData.getData("LoginCredentials");
		return data;
	}
	
	
	
	@Test(dataProvider="dataSupplier")
	public void logInFunctionalTest(String userName,String passWord)
	{
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(passWord);
	}
}
