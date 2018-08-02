package managers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	public static WebDriver driver;
	
	public abstract void startService();
	public abstract void stopService();
	public abstract WebDriver createDriver();
	
	
	
	public WebDriver getDriver() {
		System.out.println("hey an");
		if(null==driver) {
			startService();
			driver = createDriver();
		}
		return driver;
	}
	

	public void quitDriver() {
		if(null!=driver) {
			driver.quit();
			driver=null;
		}
	}
	
	
	
}
