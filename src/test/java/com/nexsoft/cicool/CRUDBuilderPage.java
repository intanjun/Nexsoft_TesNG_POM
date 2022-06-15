package com.nexsoft.cicool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRUDBuilderPage {
protected WebDriver driver;
	
	//Versi Page factory
//	@FindBy(xpath = "//a[@id='btn_add_new']")
//	private WebElement btnAdd;
//	@FindBy(xpath = "//span[normalize-space()='Select Table']")
//	private WebElement selectTable;
//	@FindBy(xpath = "//input[@id='subject']")
//	private WebElement subject;
//	@FindBy(xpath = "//input[@id='title']")
//	private WebElement title;

	@FindBy(xpath = "//tbody[@id='tbody_crud']/tr")
	List<WebElement> lstTable;
	
	public CRUDBuilderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSeeButtonwithTitle(String title) {
		WebElement see = null;
		int counter = 1;
		for (WebElement webElement : lstTable) {
//			see = webElement.findElement(By.xpath("//td/a[1]"));
//			WebElement teks = webElement.findElement(By.xpath("//td[2]"));

			see = driver.findElement(By.xpath("//tbody[@id='tbody_crud']/tr[" + counter + "]/td/a[1]"));
			WebElement teks = driver.findElement(By.xpath("//tbody[@id='tbody_crud']/tr[" + counter + "]//td[2]"));
			System.out.println(teks.getText());
			if (teks.getText().equalsIgnoreCase(title)) {
				see.click();
				break;
			}
		}
	}
	/*
//	Versi Page Factory
	public Dashboard addDataTable(String selectTable, String subject, String title) {
		selectTable.click("absensi");
		email.sendKeys(username);
		password.clear();
		password.sendKeys(user_password);
		btnSignIn.click();
		
		return new Dashboard(driver);
	}
	*/
}
