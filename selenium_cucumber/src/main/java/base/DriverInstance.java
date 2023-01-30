package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance {
	private static WebDriver driver = null;
	private static WebDriverWait wait = null;
	
//	public void setWait() {
//		wait.set
//	}
	
//	public WebDriverWait getWait() {
//		return wait.get();
//	}
	
	public void setDriver() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
}
