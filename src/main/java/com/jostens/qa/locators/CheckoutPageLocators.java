package com.jostens.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageLocators {
	
	@FindBy(xpath="//input[@id='checkout']")
	public WebElement checkoutButton;
	
	@FindBy(xpath="//input[@id='checkout_email']")
	public WebElement emailField;
	
	@FindBy(xpath="//input[@id='checkout_buyer_accepts_marketing']")
	public WebElement sendEmailsCheckbox;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_first_name']")
	public WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_last_name']")
	public WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_address1']")
	public WebElement addressField;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_city']")
	public WebElement cityField;
	
	@FindBy(xpath="//select[@id='checkout_shipping_address_country']")
	public WebElement countryDropDownList;
	
	@FindBy(xpath="//select[@id='checkout_shipping_address_province']")
	public WebElement stateDropDownList;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_zip']")
	public WebElement zipCodeField;
	
	@FindBy(xpath="//input[@id='checkout_shipping_address_phone']")
	public WebElement phoneField;
	
	@FindBy(xpath="//input[@id='checkout_remember_me']")
	public WebElement saveInfoCheckbox;
	
	@FindBy(xpath="//button[@id='continue_button']")
	public WebElement continueToShippingButton;
	
	//Verify Checkout Info WebElements
	@FindBy(xpath="//bdo[@dir='ltr']")
	public WebElement emailConfirmationField;
	
	@FindBy(xpath="//address[@class='address address--tight']")
	public WebElement addressConfirmationField;
	
	@FindBy(xpath="//td[@class='total-line__price']//span[@data-checkout-subtotal-price-target]")
	public WebElement subtotalConfirmationField;
	
	@FindBy(xpath="//td[@class='total-line__price']//span[@data-checkout-total-shipping-target]")
	public WebElement shippingCostConfirmationField;
	
	@FindBy(xpath="//span[@class='payment-due__price']")
	public WebElement totalCostConfirmationField;
	
	@FindBy(xpath="//a[@class='step__footer__previous-link']//span[contains(text(), 'Return to information')]")
	public WebElement backToShippingInfoInput;
	
}