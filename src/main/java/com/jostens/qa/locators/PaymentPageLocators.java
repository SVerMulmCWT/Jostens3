package com.jostens.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPageLocators {
	
	@FindBy(xpath="//button[@id='continue_button']")
	public WebElement continueToPaymentButton;
	
	@FindBy(xpath="//input[@id='number']")
	public WebElement creditCardNumberField;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement cardHolderNameField;
	
	@FindBy(xpath="//input[@id='expiry_month']")
	public WebElement expirationMonthField;
	
	@FindBy(xpath="//input[@id='expiry_year']")
	public WebElement expirationYearField;

	@FindBy(xpath="//input[@id='expiry']")
	public WebElement expirationDateField;
	
	@FindBy(xpath="//input[@id='verification_value']")
	public WebElement securityCodeField;
	
	@FindBy(xpath="//button[@id='continue_button']")
	public WebElement payNowButton;
	
	@FindBy(xpath="//div[@class='notice notice--error default-background']//p[@class='notice__text']")
	public WebElement paymentErrorMessage;
	
}