package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	protected WebDriver wd;
	
	public @FindBy(id = "id_username") 
	WebElement logout_btn;

	public @FindBy(id = "id_password") 
	WebElement password_textBox;

	public @FindBy(id = "btn-submit") 
	WebElement login_btn;
	
	public homePage(WebDriver wd) {
		this.wd = wd;
		PageFactory.initElements(wd, this);
	}
}
