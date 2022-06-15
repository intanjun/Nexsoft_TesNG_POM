package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
protected WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	private WebElement btn_dashboard;
	
	@FindBy(xpath = "//span[normalize-space()='CRUD Builder']")
	private WebElement btn_crudbuilder;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/a[1]")
	private WebElement btn_See;

	@FindBy(xpath = "//span[@class='hidden-xs']" )
	private WebElement username;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
//	@FindBy(xpath = "//li[contains(@class,'active')]//span[contains(text(),'Database')]")
//	private WebElement btn_dataabase;	
	
//	Versi Page Factory
	public CRUDBuilderPage clickCRUDBuilder() {
		btn_crudbuilder.click();
		CRUDBuilderPage crudBuilder = PageFactory.initElements(driver, CRUDBuilderPage.class);
		return crudBuilder;
	}
	
	public CRUDBuilderPage clik_dashboard() {
		btn_dashboard.click();
		CRUDBuilderPage clik_dashboard = PageFactory.initElements(driver, CRUDBuilderPage.class);
		return clik_dashboard;
	}

	public String getUsername() {
		return username.getText();
	}
}
