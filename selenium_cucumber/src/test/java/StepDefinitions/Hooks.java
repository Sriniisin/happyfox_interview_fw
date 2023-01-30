package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
//	WebDriver driver = getDriver();
	
//	@Before
//	public void browserSetup() {
//		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
	
	@After
	public void teardown() {
//		driver.close();
//		driver.quit();
	}
}
