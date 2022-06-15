package com.nexsoft.cicool;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginFunctionality {
protected WebDriver driver;
private JavascriptExecutor jsExe;

	public void timing(int time) {
		try {
			Thread.sleep(time);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String screenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "C:\\nexsoft\\Day20_CicoolPOM_Tugas\\screenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "http://localhost/cicool");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExe = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}
	
	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));

		// cek session user telah login atau belum
		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		home.clickSignIn().loginValidUser("intanjuniar101@gmail.com", "10101010");
//		driver.get(System.getProperty("url"));
//		home.logout();
	}
	
//	1.1 Versi POM
//	@Test
//	public void testLogin() {
//		HomePage home = new HomePage(driver);
//		SignInPage formSignIn = home.clickSignIn();
//		formSignIn.loginValidUser("intanjuniar101@gmail.com", "10101010");
//	}

//	1.2 Versi Page Factory
	@Test(priority = 1)
	public void testLogin_with_Valid_User_and_Password() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		SignInPage formSignIn = home.clickSignIn();
//		Dashboard dashboard =formSignIn.loginValidUser("dewabrata@gmail.com", "123456");
//		dashboard.clickCrudBuilder().clickSeeButtonWithTitle("Absensi");
		Dashboard dash = home.clickSignIn().loginValidUser("intanjuniar101@gmail.com", "10101010");
		
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(dash.getUsername(), "Intanjuniar101");

	}
	
	@Test(priority = 2)
	public void testLogin_With_ValidUser_and_WrongPassword() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.logout();
		SignInPage signin = home.clickSignIn();
		Dashboard dashboard = signin.loginValidUser("intanjuniar101@gmail.com", "123");
		
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorPassword(), "E-mail Address and Password do not match.");

		try {
		dashboard.getUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void testLogin_With_WrongValid_User_and_ValidPassword() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signin = home.clickSignIn();
		Dashboard dashboard = signin.loginValidUser("intanjuniar1010@gmail.com", "10101010");
		
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorUsername(), "User does not exist");

		try {
		dashboard.getUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
	}
	
	@Test(priority = 4)
	public void testLogin_With_Null_User_and_Password() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signin = home.clickSignIn();
		Dashboard dashboard = signin.loginValidUser("", "");
		
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
		
		Assert.assertEquals(signin.getErrorNull(), "The Username field is required.");
//				+ "\r\n"
//				+ "The Password field is required.");

		try {
		dashboard.getUsername();
		}catch (Exception e) {
			assertTrue(true,"Text Tidak ditemukan " + e.getMessage());
		}
	}
	
	@Test(priority = 5)
	public void testForgot_Password() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signin = home.clickSignIn();
		home.forgotPassword();
		
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}
}
