package shopperstack.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer{
	
	int count=0;
	int limit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<limit)
		{
			count++;
			return true;
		}
			
		return false;
	}

}
