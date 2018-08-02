package managers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;

public class DriverConnection {

	public static DriverConnection driverInstance;
	public static WebDriver driver;

	private DriverConnection(ChromeDriverService chService, ChromeOptions chromeOptions) {
		driver = new ChromeDriver(chService, chromeOptions);
	}

	public static DriverConnection getDriverInstance(ChromeDriverService chService, ChromeOptions chromeOptions) {
		if (driverInstance == null) {
			driverInstance = new DriverConnection(chService, chromeOptions);
		}
		return driverInstance;
	}
	
	
	private DriverConnection() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
	    firefoxOptions.setCapability("marionette", true);
	    driver = new FirefoxDriver(firefoxOptions);
	}
	
	public static DriverConnection getDriverInstance() {
		if(driverInstance==null) {
			driverInstance = new DriverConnection();
		}
		return driverInstance;
	}
	

	public WebDriver getDriver() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().window(driver.getWindowHandle());
		return driver;
	}
	
	public static void getScreenshot(ITestResult result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Screenshot/" + result + " ss.png"));

	}


}
