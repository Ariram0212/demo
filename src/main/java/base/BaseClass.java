package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import datautility.DataUtility;
import login.LoginUtility;

public class BaseClass {
	public static WebDriver driver;
	private Object browser;
	
	@BeforeClass(alwaysRun=true)
	public void openBrowser() throws IOException
	{
		String browser=System.getProperty("browser");
		if(browser.equals("Chrome")){
			driver=new ChromeDriver();
		}
		else if(browser.equals("Edge")){
			driver=new EdgeDriver();
		}
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Browser opened Successfully", true);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void logIn() throws IOException
	{
		
		driver.findElement(By.partialLinkText("Log in")).click();
		//driver.findElement(By.id("Password")).sendKeys();
		
		Reporter.log("Login Successfully", true);
	}
	
	@AfterMethod(alwaysRun=true)
	public void logOut()
	{
		//driver.findElement(By.xpath("//strong[text()='PREXO-MIS-ADMIN']")).click();
		//driver.findElement(By.xpath("//span[text()=' Logout ']")).click();
		
		Reporter.log("Logout Successfully", true);
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser Closed Successfully", true);
	}
	
}