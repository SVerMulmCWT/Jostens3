package com.jostens.qa.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.jostens.qa.locators.LoginPageLocators;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends LoginPageLocators {
	
	//Initialize Variable(s)
	ExtentTest reportLogger;
	EventFiringWebDriver eDriver;
	
	//Constructor
	public LoginPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
	}
	
	/*
	 * Method: parameters - 'url'
	 * 
	 * Purpose: Navigate to the desired Website (Jostens.com)
	 * 
	 * Return: N/A
	 * 
	 * Steps: Use the 'url' parameter to navigate/get to the specified website
	 *      The method will re-attempt to navigate/get to the specified website, up to three times, if one or more attempts fail
	 * 
	 * Used by: 'LoginPageTest.java' to go to the desired website (Jostens.com)
	 */
	public void accessWebsite(String website) {
		//Output a message to the report & system
		System.out.println("Navigating to the website -> " + website);
		reportLogger.log(LogStatus.INFO, "Navigating to the website -> " + website);
		
		//Access the specified website
		for (int i = 0; i < 3; i++) {
			try {
				eDriver.get(website);
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/*
	 * Method: parameters - 'username', 'password'
	 * 
	 * Purpose: Attempt to login to the desired website (Jostens.com)
	 * 
	 * Return: N/A
	 * 
	 * Steps: Brings up the login fields in order to login
	 *      Enters the 'username' and 'password' parameters into the login fields of the website
	 *      De-select the 'Remember Me' checkbox
	 *      Click the 'Sign in' button to attempt to login
	 * 
	 * Used by: 'LoginPageTest.java' to (attempt to) login to the desired website (Jostens.com)
	 */
	public void login(String username, String password) {
		//Output a message to the report & system
		System.out.println("Attempting to login with the userid -> " + username);
		reportLogger.log(LogStatus.INFO, "Attempting to login with the userid -> " + username);
		
		//Bring up the login input fields
		signinDropDown.click();
		
		//Enter login credentials
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		//Un-select the 'Remember Me' checkbox
		if (rememberUser.isSelected()) {
			rememberUser.click();
		}
		
		signinButton.click();
	}
	
	/*
	 * Method: parameters - N/A
	 * 
	 * Purpose: Logout from the website
	 * 
	 * Return: N/A
	 * 
	 * Steps: Bring up the the user's account functions (including the 'logout' button)
	 *      Click 'Logout'
	 * 
	 * Used by: 'LoginPageTest.java' to logout from the desired website (Jostens.com)
	 */
	public void logout() {
		//Bring up the user's account options
		accountDropDown.click();
		
		//Click the 'logout' option
		logoutButton.click();
	}
	
	/*
	 * Method: parameters - 'SoftAssert', 'expectedUserName'
	 * 
	 * Purpose: Check if the expected user logged in correctly
	 * 
	 * Return: SoftAssert - indicates if the login passed or failed
	 * 
	 * Steps: Check for the 'Welcome' message that appears after logging in
	 *      Check if the 'Welcome' message has the correct name being displayed via SoftAssert.equals() (actual display name vs the expected name [expectedUserName])
	 *      Output the SoftAssert.equals() result to the system and report
	 *      return the status of the SoftAssert
	 * 
	 * Used by: 'LoginPageTest.java' to Check/Assert the Passed/Failed status of a login test
	 */
	public SoftAssert verifySuccessfulLogin(SoftAssert softAssert, String expectedUserName) {
		//Check if the correct full name is being displayed as the 'welcome login text'
		softAssert.assertEquals(usernameWelcome.getText(), expectedUserName);
		
		//Output the results to the system and report
		if (usernameWelcome.getText().equals(expectedUserName)) {
			System.out.println("Success - user logged in correctly, with relevant name being displayed");
			reportLogger.log(LogStatus.PASS, "Success - user logged in correctly, with relevant name being displayed");
		} else if (!usernameWelcome.getText().equals("")) {
			System.out.println("Failed - user logged in, with an incorrect name being displayed. Actual Name -> " + usernameWelcome.getText() + "; Expected Name -> " + expectedUserName);
			reportLogger.log(LogStatus.FAIL, "Failed - user logged in, with an incorrect name being displayed. Actual Name -> " + usernameWelcome.getText() + "; Expected Name -> " + expectedUserName);
		} else {
			System.out.println("Failed - user failed to login, possibly due to an incorrect userid or password");
			reportLogger.log(LogStatus.FAIL, "Failed - user failed to login, possibly due to an incorrect userid or password");
		}
		
		//Return the status for the SoftAssert
		return softAssert;
	}
}