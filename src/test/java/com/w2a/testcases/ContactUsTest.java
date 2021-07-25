package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.Pages.HomePage;
import com.w2a.Pages.contactUs.ContactUsPage;
import com.w2a.utlitites.Utilties;

public class ContactUsTest extends BaseTest {
	@Test(dataProviderClass=Utilties.class,dataProvider="dp")
public void contactUsTest(Hashtable<String, String> data) {
	
//	ContactUsPage cp=new ContactUsPage();
		HomePage home = new HomePage();
		ContactUsPage contactUs=home.goToContactUs();

		contactUs.customerServiceContactUs("isha@gmail.com", "Webmaster", "HelloTest");

}
}
