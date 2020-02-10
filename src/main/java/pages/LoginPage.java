package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By emailTextbox = By.id("userEmail");
	private By passwordTextBox = By.id("password");
	private By loginButton = By.id("loginBtbn");
	
	public void enterEmail(WebDriver driver, String email) {
		enterData(driver, emailTextbox, email);
	}
	
	public void enterPassword(WebDriver driver, String password) {
		enterData(driver, passwordTextBox, password);
	}
	
	public void clickLogin(WebDriver driver) {
		clickElement(driver, loginButton);
	}
}
