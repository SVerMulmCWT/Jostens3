package com.jostens.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchSchoolPageLocators {
	
	//WebElement - click to navigate to the school search page
	@FindBy(xpath="//div[@id='utility-bar']//span[contains(text(), 'Shop Products at my School/Group')]")
	public WebElement shopProductsButton;
	
	//WebElement - input field used as search criteria for locating the desired school(s)
	@FindBy(xpath="//input[@name='search']")
	public WebElement searchSchoolName;
	
	//WebElement - click to bring up a drop-down list that has an option to 'change schools'
	@FindBy(xpath="//a[@id='affiliation-dropdown-container']")
	public WebElement schoolDropDownList;
	
	//WebElement - click to navigate to the 'school search' page (only if a school store page is already present)
	@FindBy(xpath="//div[@id='affiliation-dropdown-desktop']//div[contains(text(), 'Change School')]")
	public WebElement changeSchoolButton;
	
}