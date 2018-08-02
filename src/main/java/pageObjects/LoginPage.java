package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import resources.DataObjects;

public class LoginPage {

	WebDriver driver;
	String userDataFile;
	DataObjects data;

	public LoginPage(WebDriver driver, String userDataFile) {
		this.driver = driver;
		this.userDataFile = userDataFile;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://home.mindvalley.com']")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//div[contains(@class, 'lock-input-email')]/div[2]/span")
	private WebElement blankEmailErrorMessage;

	@FindBy(xpath = "//div[contains(@class, 'lock-input-password')]/div[2]/span")
	private WebElement blankPasswordErrorMessage;
	
	@FindBy (xpath ="//div[@id='widget-container']/div/div/form/div/div/div[2]/div/div/span/span")
	private WebElement incorrectCredentialsErrorMessage;
	
	@FindBy (xpath = "//p[@class='auth0-lock-alternative']/a")
	private WebElement passwordRecoverLink;
	
	@FindBy (xpath = "//div[@title='Forgot Password']")
	private WebElement forgotPasswordText;
	
	@FindBy (xpath = "//span[@class='auth0-lock-back-button']")
	private WebElement backToLoginPage;
	
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public WebElement getEmailTextBox() {
		return  emailTextBox;
	}

	public WebElement blankEmailErrorMessageDisplay() {
		return blankEmailErrorMessage;
	}
	
	public boolean isBlankEmailErrorMessageDisplayed() {
		return blankEmailErrorMessage.isDisplayed();
	}

	public boolean blankPasswordErrorMessage() {
		return blankPasswordErrorMessage.isDisplayed();
	}
	
	public String incorrectCredentialsErrorMessageText() {
		return incorrectCredentialsErrorMessage.getText();
	}
	
	public WebElement incorrectCredentialsErrorMessage() {
		return incorrectCredentialsErrorMessage;
	}

	public void enterIncorrectCredentials() throws JsonParseException, JsonMappingException, IOException {
		data = DataObjects.getData(userDataFile);
		emailTextBox.sendKeys(data.getInValidUserName());
		passwordTextBox.sendKeys(data.getInvalidPassword());
	}

	public void enterValidCrendentials() {
		emailTextBox.sendKeys(data.getValidUsername());
		passwordTextBox.sendKeys(data.getValidPassword());
	}

	public void clickSubmit() {
		submitButton.click();
	}
	
	public void clickPasswordRecoverLink() {
		passwordRecoverLink.click();
	}
	
	public boolean emailTextBoxDisplay() {
		return emailTextBox.isDisplayed();
	}
	
	public boolean sendEmailButtonDisplay() {
		return submitButton.isDisplayed();
	}
	
	public boolean forgotPasswordTextDisplayed() {
		return forgotPasswordText.isDisplayed();
	}
	
	public void clickBackToLoginPage() {
		backToLoginPage.click();
	}

}
