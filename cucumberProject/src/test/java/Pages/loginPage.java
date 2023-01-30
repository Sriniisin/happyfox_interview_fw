package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SeleniumBase;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class loginPage extends SeleniumBase{

	private WebDriver driver;

	public loginPage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath = "//div/input[@id='id_username']") 
	@CacheLookup
	WebElement username_txtBox;

	public @FindBy(xpath = "//div/input[@id='id_password']")
	@CacheLookup
	WebElement password_textBox;

	public @FindBy(id = "btn-submit") 
	@CacheLookup
	WebElement login_btn;

	public void navigateToUrl(String url) {
		navigate(url);
	}
	
	public void enterUsername(String un) {
		clearAndType(username_txtBox, un);
	}

	public void enterPassword(String pw) {
		clearAndType(password_textBox, pw);
	}

	public void clickLoginButton() {
		click(login_btn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public void verifyLoginPage() {
		waitForElement(login_btn);
	}

}
