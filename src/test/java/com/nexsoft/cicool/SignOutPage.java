package com.nexsoft.cicool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutPage {

	protected WebDriver driver;
	
//	private By email = By.xpath("//input[@placeholder='Email']");
//	private By password = By.xpath("//input[@placeholder='Password']");
//	private By btnSignIn = By.xpath("//button[@type='submit']");	
//	
	public SignOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Dashboard logoutWebsite() {
		driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Exit']")).click();
		
		return new Dashboard(driver);
	}
}
