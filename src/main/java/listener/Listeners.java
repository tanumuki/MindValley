package listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import managers.DriverConnection;

public class Listeners implements ITestListener  {
	
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		// Taking a screenshot on testfailure
		
		try {
			DriverConnection.getScreenshot(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
