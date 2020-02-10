package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{

	private By manageLabelHeading = By.xpath("//div[@id='managelabel']/mat-label");
	
	public String getPageHeading(WebDriver driver) {
		return getText(driver, manageLabelHeading);
	}
}
