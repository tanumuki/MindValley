package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.awaitility.Awaitility.*;
import static org.awaitility.Duration.*;
import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import enums.DriverType;
import junit.framework.Assert;
import logger.MyLogger;
import managers.DriverManager;
import managers.DriverManagerFactory;
import pageObjects.LoginPage;
import resources.DataObjects;
import utilities.Utility;

public class VerifyHomePage {

	WebDriver driver;
	DriverManager driverManager;
	LoginPage loginPage;
	DataObjects data;

	@Parameters({"userDataFile", "browser"})
	@BeforeTest
	public void init(String userDataFile, DriverType browser) throws JsonParseException, JsonMappingException, IOException {
		
		data = DataObjects.getData(userDataFile);
		driverManager = DriverManagerFactory.getManager(browser);
		driver = driverManager.getDriver();
		loginPage = new LoginPage(driver, userDataFile);
		driver.get(data.getUrl());
	}

	@Test(priority = 0)
	public void verifyLoginTest() throws InterruptedException, JsonParseException, JsonMappingException, IOException {

		MyLogger.log.info("starting tests");
		// loginPage = new LoginPage(driver, userDataFile);
		// DataObjects data = DataObjects.getData(userDataFile);

		/***
		 * Checking the flow when no credentials are entered and verifying the error
		 * messages displayed
		 */

		loginPage.clickLogin();
		MyLogger.log.info("Clicked Login button");
		Utility.waiting(loginPage.getEmailTextBox(), 10, driver);
		loginPage.clickSubmit();
		MyLogger.log.info("Clicking submit without entering the credentials");
		Utility.waiting(loginPage.blankEmailErrorMessageDisplay(), 10, driver);
		Assert.assertTrue(loginPage.isBlankEmailErrorMessageDisplayed());
		Assert.assertTrue(loginPage.blankPasswordErrorMessage());
		MyLogger.log.info("Assertions passed for error messages");

		/***
		 * Checking the flow for invalid credentials
		 */
		loginPage.enterIncorrectCredentials();
		loginPage.clickSubmit();
		Utility.waiting(loginPage.incorrectCredentialsErrorMessage(), 10, driver);
		MyLogger.log.info("Clicking submit after entering the invalid credentials");
		Assert.assertEquals(data.incorrectCredentialsErrorMessage(), loginPage.incorrectCredentialsErrorMessageText());
		MyLogger.log.info("Verified incorrect credentials error message");

	}

	@Test(priority = 1)
	public void verifyForgotPasswordTest() throws InterruptedException {
		/*
		 * Clicking on password recover link
		 */
		loginPage.clickPasswordRecoverLink();
		Thread.sleep(2000);
		Assert.assertTrue(loginPage.emailTextBoxDisplay());
		Assert.assertTrue(loginPage.sendEmailButtonDisplay());
		Assert.assertTrue(loginPage.forgotPasswordTextDisplayed());
		MyLogger.log.info("Test cases passed for password recover link and verification of text and buttons");

	}

	@Test(priority = 2)
	public void verifySuccessfulLogin() {

		/**
		 * Validating the successful login
		 */

		loginPage.clickBackToLoginPage();
		loginPage.enterValidCrendentials();
		loginPage.clickSubmit();
		MyLogger.log.info("valid credentials login scenario successful!");

	}

	@AfterTest
	public void tearDown() {
		driverManager.quitDriver();
	}

}
