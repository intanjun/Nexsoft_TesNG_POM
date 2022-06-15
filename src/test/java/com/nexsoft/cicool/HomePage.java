package com.nexsoft.cicool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
//	Versi Page Object Model(POM)
//	private By signIn = By.xpath("//a[@class='page-scroll']");
//	private By languageSetting = By.xpath("//a[@class='dropdown-toggle']");
	
	
//	Versi Page Factory
	@FindBy(xpath = "//a[@class='page-scroll']")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement languageSetting;
	
	@FindBy(xpath = "//a[@class='page-scroll dropdown-toggle']")
	private WebElement btnUsername_profile;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement btnLogout;
	
	@FindBy(xpath = "//a[normalize-space()='I forgot my password.']")
	private WebElement forgotPass;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Versi POM
//	public SignInPage clickSignIn() {
//		driver.findElement(signIn).click();
//		return new SignInPage(driver);
//	}
	
//	Versi Page Factory
	public SignInPage clickSignIn() {
		signIn.click();
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}
	
//	public boolean checkSession() {
//		if (signIn != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
	public void logout() {
		btnUsername_profile.click();
		btnLogout.click();
	}
	
	public void forgotPassword() {
		forgotPass.click();
	}
}
