package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
//	WebDriver driver;
//	
//	public Utility (WebDriver driver) {
//		this.driver = driver;
//	}
//	
	
	
	public static void waiting(WebElement element, long time , WebDriver driver) {
		
		WebDriverWait wait  =  new WebDriverWait(driver, time);
		System.out.println("loc" +element);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("utility wait ");
		
	}
	
}
