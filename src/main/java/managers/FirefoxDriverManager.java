package managers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager {

	
	private  GeckoDriverService chService;
	
	
	@Override
	public void startService() {
		if(null==chService) {
			try {
			chService=new GeckoDriverService.Builder().usingDriverExecutable(new File("src/main/java/resources/geckodriver")).usingAnyFreePort().build();
			chService.start();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void stopService() {
		if(null!=chService && chService.isRunning()) {
			chService.stop();
		}
	}

	@Override
	public WebDriver createDriver() {
		
		//System.setProperty("webdriver.gecko.driver", "src/main/java/resources/geckodriver");
		driver = DriverConnection.getDriverInstance().getDriver();
		return driver;
		
	}
	
	
	
}
