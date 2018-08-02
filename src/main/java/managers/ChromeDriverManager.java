package managers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	public ChromeDriverService chService;
	public WebDriver driver;

	@Override
	public void startService() {
		if (null == chService) {
			try {
				chService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File("src/main/java/resources/chromedriver_2")).usingAnyFreePort()
						.build();
				chService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning()) {
			chService.stop();
		}
	}

	@Override
	public WebDriver createDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = DriverConnection.getDriverInstance(chService, chromeOptions).getDriver();
		return driver;
	}

}
