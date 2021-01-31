package com.jostens.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageLocators {
	
	@FindBy(xpath="//a[@href='/account/login']")
	public WebElement loginPageButton;
	
	@FindBy(xpath="//header[@id='header']//span[contains(text(), 'Cart')]")
	public WebElement cartCheckout;
	
	@FindBy(xpath="//form[@id='cart_form']//div[@data-line-item='0']//span[@class='money ']")
	public WebElement productPricePerProduct;
	
	@FindBy(xpath="//form[@id='cart_form']//div[@data-line-item='0']//input[@class='quantity-input quantity-element input']")
	public WebElement productCount;
	
	@FindBy(xpath="//form[@id='cart_form']//div[@data-line-item='0']//span[@class='money']")
	public WebElement productPriceTotal;
	
	@FindBy(xpath="//form[@id='cart_form']//p[@class='h3 cart__subtotal']//span[@class='money']")
	public WebElement subtotal;
	
}