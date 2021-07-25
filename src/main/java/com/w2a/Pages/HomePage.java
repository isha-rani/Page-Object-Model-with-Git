package com.w2a.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.BasePage.Page;
import com.w2a.Pages.contactUs.ContactUsPage;

import WomenPage.WomenPage;

public class HomePage extends Page{

	public WomenPage goToWomen() {
//	driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
		click("MenuWomenLink_Xpath");
	return new WomenPage();
	}
public void goToDress() {
//	driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
	click("MenuDressLink_Xpath");
}
public void goToTShirts() {
//	driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
	click("menuShirtsLink_Xpath");
}

public ContactUsPage goToContactUs() {
//	driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
	click("topMenuContactUsLink_Xpath");
	return new ContactUsPage();
}

public LoginPage goToSignIn() {
//	driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	click("SignInLink_Xpath");
	return new LoginPage();
}
public void goToCart() {
//	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")).click();
	click("goToCartLink_Xpath");
}

public void goToSignOut() {
//	driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
	click("signOutLink_Xpath");
}

public void goToPopularDresses() {
//	driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[1]/a")).click();
	click("PopularDressesLink_Xpath");
}
public void goToBestSellerDresses() {
//	driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a")).click();
	click("BestSellerDressesLink_Xpath");
}

public void goToYourAccountInfo() {
//	driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	click("AccountUsernameLink_Xpath");
}
public void goToFooter() {
//	driver.findElement(By.xpath("//*[@id=\"footer\"]")).click();
	
	click("footer_Xpath");
}
}
