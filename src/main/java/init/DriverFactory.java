package init;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.FilesUtility;

public class DriverFactory {
	FilesUtility file = new FilesUtility();
	
	public WebDriver launchBrowser() throws IOException {
		String browser = file.getValueFromPropertyFile("browserName");
		String url = file.getValueFromPropertyFile("url");
		
		WebDriver driver = null;
		
		switch (browser) {
		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "src/../drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			break;
		}
		case "ie":
		{
			System.setProperty("webdriver.ie.driver", "src/../drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.navigate().to("https://msnagile.com");
			break;
		}
		default: break;
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
}

