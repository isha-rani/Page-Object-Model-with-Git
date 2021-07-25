package com.w2a.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.BasePage.Page;

public class LoginPage extends Page {
//	WebDriver driver;
//	public LoginPage(WebDriver driver) {
//		this.driver=driver;
//	}
	public void doLogin(String username, String password) {
//		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		type("inputEmail_Xpath", username);
//		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
		type("inputPassword_Xpath",password);
//		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		click("submitLoginBtn_Xpath");
	}
}
