package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.Pages.HomePage;
import com.w2a.Pages.LoginPage;
import com.w2a.Pages.contactUs.ContactUsPage;

import WomenPage.WomenPage;
import WomenPage.WomenTopsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
public static void main(String[] args) {

	HomePage home = new HomePage();
	LoginPage login=home.goToSignIn();
	login.doLogin("ishakhurna21@gmail.com", "Mysterious21@");
	
	WomenPage wp=home.goToWomen();

	WomenTopsPage womentop=wp.goToTops();
	womentop.goToTShirts();
	
	ContactUsPage contactUs=home.goToContactUs();

	contactUs.customerServiceContactUs("isha@gmail.com", "Webmaster", "HelloTest");
}
}
