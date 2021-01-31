package com.jostens.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPageLocators {
	
	@FindBy(xpath="//h3[contains(text(), 'School Store')]")
	public WebElement schoolStoreButton;
	
	//WebElement that contains exclusively text asking the user to accept cookies (the button to accept cookies is another @FindBy(WebElement)
	@FindBy(xpath="//p[contains(text(), 'We use cookies on our website')]")
	public WebElement cookiesMessage;
	
	//WebElement - click to accept cookies
	@FindBy(xpath="//a[contains(text(), 'I Agree') and @class='button button--primary js-close-fixed-message']")
	public WebElement cookiesAccept;
	
	//WebElement - click to leave a product's detail page & back to the school's store
	@FindBy(xpath="//div[@class='breadcrumb__wrapper']//a[contains(@href, '/collections/')]")
	public WebElement backToStore;
	
	@FindBy(xpath="//select[@name='logoPosition']")
	public WebElement productLogoPositionSelection;
	
	@FindBy(xpath="//div[@id='shopify-section-product__main']//div[@class='logo-box']")
	public WebElement productLogoCoordinates;
	
	//form[@id="product_form_4341286043702"]//button[@name='add']
	@FindBy(xpath="//button[@name='add']")
	public WebElement addToCartButton;
	
}