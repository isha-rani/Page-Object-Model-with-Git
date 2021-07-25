package WomenPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.BasePage.Page;

public class WomenPage extends Page {

	public WomenTopsPage goToTops() {

//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/h5/a")).click();
		click("subcategoryTopsLink_Xpath");
		return new WomenTopsPage();
	}
	
	public WomenDressesPage goToDresses() {

//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).click();
		click("subcategoryDressesLink_Xpath");
		return new WomenDressesPage();
	}

}
