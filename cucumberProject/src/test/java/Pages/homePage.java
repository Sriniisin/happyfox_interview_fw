package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SeleniumBase;

public class homePage extends SeleniumBase {
	private WebDriver driver;

	public homePage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath = "//*[@title='Tickets']") 
	WebElement ticket_menu;

	public @FindBy(xpath = "//a[text()='Statuses']") 
	WebElement status_menu;
	
	public @FindBy(xpath = "//a[text()='Priorities']")
	WebElement priority_menu;

	public void clickStatuses() {
		waitForApperance(ticket_menu);
		mouseHover(ticket_menu);
		click(ticket_menu);
		mouseHoverAndClick(status_menu);
		click(status_menu);
	}
	
	public void clickPriorities() {
		waitForApperance(ticket_menu);
		mouseHover(ticket_menu);
		click(ticket_menu);
		mouseHoverAndClick(priority_menu);
		click(priority_menu);
	}
}
