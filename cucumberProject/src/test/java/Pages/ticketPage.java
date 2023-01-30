package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SeleniumBase;

public class ticketPage extends SeleniumBase {
	private WebDriver driver;

	public ticketPage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath = "//a[text()='Close']")
	WebElement ticket_close;
	
	public @FindBy(xpath = "//div[text()='priority']/following-sibling::div")
	WebElement priority_value;
	
	public @FindBy(xpath = "//span[text()='Reply']")
	WebElement reply_btn;
	
	public @FindBy(xpath = "//span[text()='Canned Action']")
	WebElement cannedAction_btn;
	
	public @FindBy(xpath = "//li[text()='Reply to Customer Query']")
	WebElement replyWithCannedAction;
	
	public @FindBy(xpath = "//button[text()='Apply']")
	WebElement Apply;
	
	public @FindBy(xpath = "//button[text()='Add Reply']")
	WebElement sendReply;
	
	public @FindBy(xpath = "//div/span[text()='Closed']")
	WebElement updatedState;
	
	public String returnPriorityValue() {
		waitForApperance(ticket_close);
		String priority = getInnerText(priority_value);
		return priority;
	}
	
	public Boolean checkPriorityValueOfTicket(String Priority) {
		Boolean state = false;
		if(Priority.equalsIgnoreCase("Assistance required")) {
			state = true;
		}
		return state;
	}
	
	public void clickReply() {
		waitForApperance(reply_btn);
		click(reply_btn);
	}
	
	public void sendReplyWithCannedActionsMessage() {
		waitForApperance(cannedAction_btn);
		click(cannedAction_btn);
		waitForApperance(replyWithCannedAction);
		click(replyWithCannedAction);
		click(Apply);
		click(sendReply);
		waitForApperance(updatedState);
	}
	
	public Boolean checkUpdatedTicketState() {
		Boolean state = false;
		String Status = getInnerText(updatedState);
		if(Status.equalsIgnoreCase("Closed")) {
			state = true;
		}
		return state;
	}
}