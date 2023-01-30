package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class loginPage extends CommonMethods{
//	protected WebDriver driver = DriverUtil.getDefaultDriver();

	public loginPage(WebDriver driver) {
		PageFactory.initElements(CommonMethods.driver, this);
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

	public void enterUsername(String un) {
//		username_txtBox.sendKeys(un);
		enterText(username_txtBox, un);
	}

	public void enterPassword(String pw) {
//		password_textBox.sendKeys(pw);
		enterText(password_textBox, pw);
	}

	public void clickLoginButton() {
//		login_btn.click();
		click(login_btn);
	}
	
	public void navigateToUrl(String url) {
		navigate(url);
	}
}
