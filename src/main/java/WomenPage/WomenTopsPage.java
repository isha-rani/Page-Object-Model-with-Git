package WomenPage;

import org.openqa.selenium.By;

import com.w2a.BasePage.Page;

public class WomenTopsPage extends Page {
	public void goToTShirts() {
//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/h5/a")).click();
		click("subcategoryShirts_Xpath");
	}

	public void goToBlouses() {
//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).click();
		click("subcategoryBlouses_Xpath");
	}
}
