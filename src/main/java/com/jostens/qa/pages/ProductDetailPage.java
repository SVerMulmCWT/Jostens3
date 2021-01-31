package com.jostens.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.jostens.qa.locators.ProductDetailPageLocators;
import com.jostens.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductDetailPage extends ProductDetailPageLocators {
	
	//Initialize Variable(s)
	ExtentTest reportLogger;
	EventFiringWebDriver eDriver;
	
	TestUtil genMethods;
	
	//Constructor
	public ProductDetailPage(EventFiringWebDriver eDriver, ExtentTest reportLogger) {
		this.reportLogger = reportLogger;
		this.eDriver = eDriver;
		PageFactory.initElements(eDriver, this);
		
		//initialize the generic methods for this class
		genMethods = new TestUtil();
	}
	
	public void clickSchoolStoreButton() {
		//Output a message to the report & system
		System.out.println("Attempting to navigate to the school store");
		reportLogger.log(LogStatus.INFO, "Attempting to navigate to the school store");
		
		//Click the School Store button
		schoolStoreButton.click();
	}
	
	/*
	 * When going into the School Store Page, there may be a message asking to accept cookies
	 * This method checks if there is a message asking the user/script to accept the cookies
	 * If the message exists, the method accepts the cookies by selecting, 'I Agree'
	 * 
	 * This method should be called right after the 'School Store Page' is accessed, if the user wants the script to accept the cookies
	 * This method is used in the @Test method in the 'LoginPageTest.java' class (underneath the 'src/test/java' folder & 'com.jostens.qa.testcases' package)
	 */
	public void acceptCookies() {
		//Output a message to the report & system
		System.out.println("Select the 'Tee' filter");
		reportLogger.log(LogStatus.INFO, "Select the 'Tee' filter");
		
		//Accept the cookies, if the option is present
		if (cookiesMessage.isDisplayed()) {
			cookiesAccept.click();
		}
	}
	
	/*
	 * This method attempts to locate & select a product, which brings up that products detailed page
	 * Once the product's detailed page is brought up, the user/script can check different designs, sizes, description, etc.
	 * The product can also be added to the cart from the product's detailed page (covered in other method[s])
	 * 
	 * This method is used in the @Test method in the 'LoginPageTest.java' class (underneath the 'src/test/java' folder & 'com.jostens.qa.testcases' package)
	 */
	public void selectProduct(String product) throws InterruptedException {
		//Output a message to the report & system
		System.out.println("Attempting to select the specified product -> " + product);
		reportLogger.log(LogStatus.INFO, "Attempting to select the specified product -> " + product);
		
		//Create a specific/dynamic xpath expression based on which product is desired
		String xpathExp = genMethods.createXPath("//a[contains(text(), \"{0}\")]", product);
		String xpathAddendum = "//parent::div[@class='product-thumbnail']//parent::div[@class='thumbnail__caption text-align-center']//parent::div[@class='product-wrap']//div[@class='product-image__wrapper']";
		xpathExp = xpathExp + xpathAddendum;
		
		Thread.sleep(6000);
		
		//Click on the specified product
		eDriver.findElement(By.xpath(xpathExp)).click();
	}
	
	public void returnToSchoolStore() {
		try {
			Thread.sleep(1000);
			Actions actions = new Actions(eDriver);
			actions.moveToElement(backToStore);
			actions.perform();
			Thread.sleep(1000);
			backToStore.click();
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public SoftAssert verifySuccessfulProductSearch(SoftAssert softAssert, String productName) {
		//Initialize Variable(s)
		String productPageTitle = eDriver.getTitle();
		
		softAssert.assertEquals(productPageTitle, productName);
		
		//Return the status for the SoftAssert
		return softAssert;
	}
	public void selectProductColor(String color) {
		//Output a message to the report & system
		System.out.println("Attempting to select the specified color -> " + color);
		reportLogger.log(LogStatus.INFO, "Attempting to select the specified color -> " + color);
		
		//Create a specific/dynamic xpath expression based on which product color is desired
		String xpathExp = genMethods.createXPath("//div[@data-value=\"{0}\"]", color);
		
		//Select the desired product color (if not found, the default color will remain selected)
		if (eDriver.findElement(By.xpath(xpathExp)).isDisplayed()) {
			eDriver.findElement(By.xpath(xpathExp)).click();
		}
	}
	
	public void selectProductSize(String size) {
		//Output a message to the report & system
		System.out.println("Attempting to select the specified size -> " + size);
		reportLogger.log(LogStatus.INFO, "Attempting to select the specified size -> " + size);
		
		//Create a specific/dynamic xpath expression based on which product color is desired
		String xpathExp = genMethods.createXPath("//div[@data-value=\"{0}\"]", size);
		
		//Click the desired product size (if not found, the default size will remain selected)
		if (eDriver.findElement(By.xpath(xpathExp)).isDisplayed()) {
			eDriver.findElement(By.xpath(xpathExp)).click();
		}
	}
	
	public void selectProductLogo(int logoNumber) throws InterruptedException {
		//Output a message to the report & system
		System.out.println("Attempting to select the specified logo from the list, located at #" + logoNumber);
		reportLogger.log(LogStatus.INFO, "Attempting to select the specified logo from the list, located at #" + logoNumber);
		
		//Initialize the List of all WebElements that contain a logo
		List<WebElement> logoList = eDriver.findElements(By.xpath("//div[@id='design-selectors-container']//label[@class='valtira-radio-design']"));
		
		//Set the logoNumber's value to correspond with the xth entry of the list of logos
		if (logoNumber > 0 && logoNumber <= logoList.size()) {
			logoNumber = logoNumber - 1;
		} else {
			logoNumber = 0;
		}
		
		//Select the logo based on the 'logo number' sent in by the user
		logoList.get(logoNumber).click();
	}
	
	public void selectProductLogoPosition(String logoPosition) {
		//Output a message to the report & system
		System.out.println("Attempting to select the logo position -> " + logoPosition);
		reportLogger.log(LogStatus.INFO, "Attempting to select the logo position -> " + logoPosition);
		
		//Setup a 'Select' variable in reference to the Drop-Down WebElement that has the options for the logo's positions
		Select select = new Select(productLogoPositionSelection);
		
		//Select the relevant option from the drop-down list
		select.selectByVisibleText(logoPosition);
	}
	
	public SoftAssert verifyProductLogoCoordinates(SoftAssert softAssert, String left, String top, String width, String height) {
		//Initialize Variable(s)
		boolean verificationStatus = false; //The 'verificationStatus' becomes 'true' if the logo's position passed successfully
		String positionAttribute = productLogoCoordinates.getAttribute("style");
		String leftAttribute = "left: " + left + "%";
		String topAttribute = "top: " + top + "%";
		String widthAttribute = "width: " + width + "%";
		String heightAttribute = "height: " + height + "%";
		
		//Check if all the positions match expectations, then output the results to the report & system, and return the status for the @Test's SoftAssert
		if (positionAttribute.contains(leftAttribute) && positionAttribute.contains(topAttribute) && positionAttribute.contains(widthAttribute) && positionAttribute.contains(heightAttribute)) {
			verificationStatus = true;
			System.out.println("Product's Logo Position Successful - The logo's coordinates/location on the T-Shirt matches expectations.");
			reportLogger.log(LogStatus.PASS, "Product's Logo Position Successful - The logo's coordinates/location on the T-Shirt matches expectations.");
		} else {
			verificationStatus = false;
			System.out.println("Product's Logo Position Failed - The logo's coordinates/location on the T-Shirt does not match expectations.");
			reportLogger.log(LogStatus.FAIL, "Product's Logo Position Failed - The logo's coordinates/location on the T-Shirt does not match expectations.");
		}
		
		//Check if the 'left' position matches expectations
		if (!positionAttribute.contains(leftAttribute)) {
			System.out.println("Product's Logo Position Failed - The logo's 'left' position on the T-Shirt does not match expectations. Expected 'left' position = " + leftAttribute + ". Actual position = " + positionAttribute);
			reportLogger.log(LogStatus.FAIL, "Product's Logo Position Failed - The logo's 'left' position on the T-Shirt does not match expectations. Expected 'left' position = " + leftAttribute + ". Actual position = " + positionAttribute);
		}
		
		//Check if the 'top' value/position matches expectations
		if (!positionAttribute.contains(topAttribute)) {
			System.out.println("Product's Logo Position Failed - The logo's 'top' value/position on the T-Shirt does not match expectations. Expected 'top' value/position = " + topAttribute + ". Actual position = " + positionAttribute);
			reportLogger.log(LogStatus.FAIL, "Product's Logo Position Failed - The logo's 'top' value/position on the T-Shirt does not match expectations. Expected 'top' value/position = " + topAttribute + ". Actual position = " + positionAttribute);
		}
		
		//Check if the 'width' value/position matches expectations
		if (!positionAttribute.contains(widthAttribute)) {
			System.out.println("Product's Logo Position Failed - The logo's 'width' value/position on the T-Shirt does not match expectations. Expected 'width' value/position = " + widthAttribute + ". Actual position = " + positionAttribute);
			reportLogger.log(LogStatus.FAIL, "Product's Logo Position Failed - The logo's 'width' value/position on the T-Shirt does not match expectations. Expected 'width' value/position = " + widthAttribute + ". Actual position = " + positionAttribute);
		}
		
		//Check if the 'height' position matches expectations
		if (!positionAttribute.contains(heightAttribute)) {
			System.out.println("Product's Logo Position Failed - The logo's 'height' value/position on the T-Shirt does not match expectations. Expected 'height' value/position = " + heightAttribute + ". Actual position = " + positionAttribute);
			reportLogger.log(LogStatus.FAIL, "Product's Logo Position Failed - The logo's 'height' value/position on the T-Shirt does not match expectations. Expected 'height' value/position = " + heightAttribute + ". Actual position = " + positionAttribute);
		}
		
		//Run the position check(s) through the SoftAssert, then return the SoftAssert
		softAssert.assertTrue(verificationStatus);
		
		//Return the status for the SoftAssert
		return softAssert;
	}
	
	public void addToCart() {
		//Output a message to the report & system
		System.out.println("Adding the product to the Shopping Cart");
		reportLogger.log(LogStatus.INFO, "Adding the product to the Shopping Cart");
		
		//Check if the product is able to be added to the shopping cart
		if (addToCartButton.getText().equals("Sold Out")) {
			System.out.println("SOLD OUT - Cannot add the product to the Shopping Cart");
			reportLogger.log(LogStatus.INFO, "SOLD OUT - Cannot add the product to the Shopping Cart");
		}
		
		//Click to add the specified product to the Shopping Cart
		addToCartButton.click();
	}
	
}