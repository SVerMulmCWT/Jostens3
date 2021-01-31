package com.jostens.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	
	//WebElement - click to bring down the drop-down list in order to access the login fields & button
	@FindBy(xpath="//a[@id='sign-in-dropdown-toggle__utility-bar']")
	public WebElement signinDropDown;
	
	//WebElement - input field that holds/receives the user's username
	@FindBy(xpath="//input[@id='username']")
	public WebElement usernameField;
	
	//WebElement - input field that holds/receives the user's password
	@FindBy(xpath="//input[@id='password']")
	public WebElement passwordField;
	
	//WebElement - checkbox that tells the website whether to remember the user's credentials
	@FindBy(xpath="//input[@id='remember']")
	public WebElement rememberUser;
	
	//WebElement - click to login with the current, specified credentials
	@FindBy(xpath="//div[@id='sign-in-dropdown-desktop']//button[contains(text(), 'Sign In')]")
	public WebElement signinButton;
	
	//WebElement - displays the account owner's name after login
	@FindBy(xpath="//span[@id='profile-username']")
	public WebElement usernameWelcome;
	
	//WebElement - click to bring down the user's account options
	@FindBy(xpath="//a[@id='user-dropdown-toggle__utility-bar']")
	public WebElement accountDropDown;
	
	//WebElement - click to logout of account
	@FindBy(xpath="//div[@id='user-dropdown-desktop']//div[@class='link-section link-section--1-cols']//ul[@class='list-unstyled']//a[contains(text(), 'Logout')]")
	public WebElement logoutButton;
	
}