package testscript;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import login.LoginUtility;

public class LogInFunctionalTest extends BaseClass{
	@DataProvider
	public Object[][] dataSupplier()
	{
		LoginUtility readData=new LoginUtility();
		Object[][] data=readData.getData("LoginCredentials");
		return data;
	}
	
	
	
	@Test(dataProvider="dataSupplier",groups = "smoke")
	public void logInFunctionalTest(String userName,String passWord)
	{
		
		String browser=System.getProperty("browser");
		System.out.println(browser);
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(passWord);
	}
}
