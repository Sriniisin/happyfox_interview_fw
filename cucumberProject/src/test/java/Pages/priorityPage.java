package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SeleniumBase;

public class priorityPage extends SeleniumBase {
	private WebDriver driver;

	public priorityPage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	public @FindBy(xpath = "//button[@*='new-priority']") WebElement add_new_priority;

	public @FindBy(xpath = "//input[@*='Priority Name']") WebElement priority_name;

	public @FindBy(xpath = "//textArea[@*='Description']") WebElement description_txtBox;

	public @FindBy(xpath = "//button[@*='add-priority']") WebElement submit_btn;

	public @FindBy(xpath = "//div[text()='Make Default']/parent::div/parent::td/preceding-sibling::td/span[text()='Assistance required']") WebElement added_Pri;

	public @FindBy(xpath = "//span[text()='Assistance required']/parent::td/following-sibling::td//div[text()='Make Default']") WebElement makeDefault;

	public @FindBy(xpath = "//div[@*='default-priority']") WebElement defaultPriorityIcon;

	public @FindBy(xpath = "//button/span[text()='New Ticket']") WebElement create_ticket;

	public @FindBy(xpath = "//input[@*='new-ticket-contact-name-value']") WebElement fullName_textBox;

	public @FindBy(xpath = "//input[@*='new-ticket-contact-email-value']") WebElement email_txtbox;

	public @FindBy(xpath = "//input[@*='new-ticket-subject-value']") WebElement subject_textbox;

	public @FindBy(xpath = "//div[@id='cke_newTicket']/div/div/div") WebElement message_textbox;

	public @FindBy(xpath = "//button[@*='new-ticket-create']") WebElement submitTicket_btn;

	public @FindBy(xpath = "//span[text()='Assistance required']") WebElement added_priority;

	public @FindBy(xpath = "//a[text()='Delete']") WebElement delete_priority;

	public @FindBy(xpath = "//button[text()='Delete']") WebElement delete_confirmation;

	public @FindBy(xpath = "//div[@*='toast-message']") WebElement toast_message;

	public @FindBy(xpath = "//div[@*='staff-menu']/div") WebElement logout_menu;

	public @FindBy(xpath = "//a[text()='Logout']") WebElement logout;

	public @FindBy(xpath = "//span[text()='Choose Priority']") WebElement choose_status;

	public @FindBy(xpath = "//li[text()='Medium']") WebElement medium_option;

	public void addNewStatus() {
		waitForApperance(add_new_priority);
		click(add_new_priority);
	}

	public void addPriorityDetails(String name, String Description) {
		clearAndType(priority_name, name);
		clearAndType(description_txtBox, Description);
		click(submit_btn);
		waitForApperance(added_Pri);
	}

	public Boolean checkPriority() {
		Boolean state = verifyDisplayed(added_Pri);
		return state;
	}

	public void makePriorityDefault() {
//		waitForApperance(makeDefault);
		mouseHoverAndClick(makeDefault);
//		click(makeDefault);
	}

	public Boolean checkDefaultIcon() {
		Boolean state = verifyDisplayed(defaultPriorityIcon);
		return state;
	}

	public void clickCreateTicket() {
		waitForApperance(create_ticket);
		click(create_ticket);
	}

	public void enterTicketDetails(String name, String email, String subject, String message) {
		waitForApperance(fullName_textBox);
		clearAndType(fullName_textBox, name);
		clearAndType(email_txtbox, email);
		clearAndType(subject_textbox, subject);
		clearAndType(message_textbox, message);
		waitForApperance(submitTicket_btn);
		click(submitTicket_btn);
	}

	public void clickPriority() {
		click(added_priority);
	}

	public void deletePriority() {
		click(delete_priority);
		waitForApperance(delete_confirmation);
		if (verifyIsPresent("//span[text()='Choose Priority']")) {
			click(choose_status);
			click(medium_option);
		}
		click(delete_confirmation);
		waitForApperance(toast_message);
	}

	public void Logout() {
		waitForApperance(logout_menu);
		click(logout_menu);
		waitForApperance(logout);
		click(logout);
	}
}