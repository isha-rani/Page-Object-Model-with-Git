package WomenPage;

import org.openqa.selenium.By;

import com.w2a.BasePage.Page;

public class WomenDressesPage extends Page {
	public void goToCasualDresses() {
//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/h5/a")).click();
		click("subcategoryCasualDresses_Xpath");
	}

	public void goToEveningDresses() {
//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).click();
		click("subcategoryEveningDresses_Xpath");
	}

	public void goToSummerDresses() {
//		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[3]/h5/a")).click();
		click("subcategorySummerDresses_Xpath");
	}
}
