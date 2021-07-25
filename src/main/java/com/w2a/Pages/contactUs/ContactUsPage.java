package com.w2a.Pages.contactUs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.w2a.BasePage.Page;

public class ContactUsPage extends Page{
	public void customerServiceContactUs(String email, String subjectHeading, String message) {
		
		WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"id_contact\"]"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Webmaster");
		
//		driver.findElement(By.xpath("//*[@id=\"id_contact\"]")).sendKeys(subjectHeading);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		type("inputContactEmail_Xpath",email);
//		driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(message);
		type("inputMessage_Xpath",message);
//		driver.findElement(By.xpath("//*[@id=\"submitMessage\"]")).click();
		click("submitMsgBtn_Xpath");
	}
}
