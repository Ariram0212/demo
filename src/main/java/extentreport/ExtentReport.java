package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public void demoReport() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./shoppers-stack/advancedreports/demo.html");
		ExtentReports report =new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test=report.createTest("demo");
		test.log(Status.PASS, "status is passed");
		test.log(Status.FAIL, "status is failed");
		test.log(Status.SKIP, "status is skipped");
		test.log(Status.INFO, "status is announced");
		report.flush();
	}
}
