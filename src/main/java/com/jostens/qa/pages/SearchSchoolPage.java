package com.jostens.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.jostens.qa.locators.SearchSchoolPageLocators;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchSchoolPage extends SearchSchoolPageLocators {
	
	//Initialize Variable(s)
	ExtentTest reportLogger;
	EventFiringWebDriver eDriver;
	
	//Constructor
	public SearchSchoolPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
	}
	
	/*
	 * Method: parameters - N/A
	 * 
	 * Purpose: Navigate to the 'school search' page
	 * 
	 * Return: N/A
	 * 
	 * Steps: Click the button, labeled 'Shop Products at my School/Group' to bring up the school/group search page
	 * 
	 * Used by: 'SearchSchoolPageTest.java' to go to the 'search school' page
	 */
	public void goToSchoolSearch() {
		//Output a message to the report & system
		System.out.println("Proceeding to the School Search Page");
		reportLogger.log(LogStatus.INFO, "Proceeding to the School Search Page");
		
		//Click to proceed to the School Search Page
		shopProductsButton.click();
	}
	
	/*
	 * Method: parameters - N/A
	 * 
	 * Purpose: Navigate to the 'school search' page
	 * 
	 * Return: N/A
	 * 
	 * Steps: Click the school drop-down list that allows the user to change schools
	 *      Click the button, labeled 'Change School' to bring up the school/group search page
	 * 
	 * Used by: 'SearchSchoolPageTest.java' to go to the 'search school' page
	 */
	public void goToChangeSchool() {
		//Output a message to the report & system
		System.out.println("Proceeding to the School Search Page");
		reportLogger.log(LogStatus.INFO, "Proceeding to the School Search Page");
		
		//Click the School drop-down list to locate the 'Change School' option
		schoolDropDownList.click();
		
		//Click the 'Change School' option
		changeSchoolButton.click();
	}
	
	/*
	 * Method: parameters - N/A
	 * 
	 * Purpose: Search for a school, and select the desired school from a drop-down list (of search results)
	 * 
	 * Return: N/A
	 * 
	 * Steps: Enter the search criteria (name of the school)
	 *      Retrieve a list of all the listed search results
	 *      iterate through the list, and select the listing that matches the search criteria
	 * 
	 * Used by: 'SearchSchoolPageTest.java' to search for the appropriate school page
	 */
	public void searchSchool(String school) {
		//Output a message to the report & system
		System.out.println("Attempting search for the school -> " + school);
		reportLogger.log(LogStatus.INFO, "Attempting search for the school -> " + school);
		
		//Initialize Variable(s)
		boolean schoolFound = false; //Becomes true, if the school is found - if it remains false, the script will select the first school from the search results
		
		//Enter the search criteria (school name)
		searchSchoolName.sendKeys(school);
		
		//Retrieve the list of search results
		List<WebElement> schoolList = eDriver.findElements(By.xpath("//tbody[@class='results' and @data-url='/apps/profile/setCustomer.mvc']//td[@class='customer-name']"));
		
		//Loop through the search results & click the relevant search result
		for (int i = 0; i < schoolList.size(); i++) {
			
			if (schoolList.get(i).getText().equals(school)) {
				schoolFound = true;
				schoolList.get(i).click();
				break;
			}
		}
		
		/*
		 * If the desired school was not found in the search results, select the first entry of the results
		 * This way, the rest of the test (suite) can continue, even if the relevant school was not found
		 */
		if (!schoolFound) {
			schoolList.get(0).click();
		}
	}
	
	/*
	 * Method: parameters - 'SoftAssert', 'schoolName'
	 * 
	 * Purpose: Check if the expected school store page loaded correctly
	 * 
	 * Return: SoftAssert - indicates if the school search passed or failed
	 * 
	 * Steps: Retrieve the title of the school store page
	 *      Check if the actual/displayed school store page matches expectations (schoolName) via SoftAssert.equals()
	 *      Output the SoftAssert.equals() result to the system and report
	 *      return the status of the SoftAssert
	 * 
	 * Used by: 'LoginPageTest.java' to Check/Assert the Passed/Failed status of a login test
	 */
	public SoftAssert verifySuccessfulSchoolSearch(SoftAssert softAssert, String schoolName) {
		//Initialize Variable(s)
		String schoolPageTitle = eDriver.getTitle();
		
		//Check if the correct school name title is being displayed as the current school store's title
		softAssert.assertEquals(schoolPageTitle, schoolName);
		
		//Output the results to the system and report
		if (schoolPageTitle.equals(schoolName)) {
			System.out.println("Success - the relevant school store page loaded correctly");
			reportLogger.log(LogStatus.PASS, "Success - the relevant school store page loaded correctly");
		} else {
			System.out.println("Failed - the relevant school store page did not load correctly. Actual School Store title -> " + schoolPageTitle + "; Expected School Store title -> " + schoolName);
			reportLogger.log(LogStatus.FAIL, "Failed - the relevant school store page did not load correctly. Actual School Store title -> " + schoolPageTitle + "; Expected School Store title -> " + schoolName);
		}
		
		//Return the status for the SoftAssert
		return softAssert;
	}
	
}