package managers;

import org.openqa.selenium.WebDriver;

public class SafariDriverManager extends DriverManager {

	
	public void test() {
		System.out.println("safari");
	}

	@Override
	public void startService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
