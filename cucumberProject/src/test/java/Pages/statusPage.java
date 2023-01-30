package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SeleniumBase;

public class statusPage extends SeleniumBase {
	private WebDriver driver;

	public statusPage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	public @FindBy(xpath = "//button[@*='new-status']") WebElement add_new_status;

	public @FindBy(xpath = "//input[@*='Status Name']") WebElement status_name;

	public @FindBy(xpath = "//textArea[@*='Description']") WebElement description_txtBox;

	public @FindBy(xpath = "//button[@*='add-status']") WebElement submit_btn;

	public @FindBy(xpath = "//div[@*='toast-message']") WebElement toast_message;

	public @FindBy(xpath = "//a[text()='Cancel']") WebElement cancel_btn;

	public @FindBy(xpath = "//span[@*='toast-message-close']") WebElement close_toastmessage;

	public @FindBy(xpath = "//a[@*='Priorities']") WebElement priority_option;

	public @FindBy(xpath = "//div[text()='Issue created']") WebElement newStatusCreated;

	public @FindBy(xpath = "//div[text()='Issue created']/parent::div/parent::td/following-sibling::td//a[text()='Make Default']") WebElement makeDefault;

	public @FindBy(xpath = "//div[@*='default-status']") WebElement defaultStatusIcon;

	public @FindBy(xpath = "//div[text()='Issue created']") WebElement added_status;

	public @FindBy(xpath = "//a[text()='Delete']") WebElement delete_status;

	public @FindBy(xpath = "//button[text()='Delete']") WebElement delete_confirmation;

	public @FindBy(xpath = "//span[text()='Choose Status']") WebElement choose_status;

	public @FindBy(xpath = "//li[text()='In Progress']") WebElement inProgress_option;

	public void addNewStatus() {
		waitForApperance(add_new_status);
		click(add_new_status);
	}

	public void addStatusDetails(String name, String behaviour, String Description) {
		clearAndType(status_name, name);
		clearAndType(description_txtBox, Description);
		click(submit_btn);
//		waitForApperance(toast_message);
	}

	public Boolean checkStatus() {
		waitForApperance(newStatusCreated);
		Boolean state = verifyDisplayed(newStatusCreated);
		return state;
	}

	public Boolean checkErrorMessage() {
		Boolean state = verifyDisplayed(toast_message);
		return state;
	}

	public void makeStatusDefault() {
//		waitForApperance(makeDefault);
		mouseHoverAndClick(makeDefault);
//		click(makeDefault);
	}

	public Boolean checkDefaultIcon() {
		Boolean state = verifyDisplayed(defaultStatusIcon);
		return state;
	}

	public void clickPriorities() {
		waitForApperance(priority_option);
		click(priority_option);
	}

	public void clickStatus() {
		click(added_status);
	}

	public void deleteStatus() {
		click(delete_status);
		waitForApperance(delete_confirmation);
		if (verifyIsPresent("//span[text()='Choose Status']")) {
			click(choose_status);
			click(inProgress_option);
		}
		click(delete_confirmation);
		waitForApperance(toast_message);

		clickPriorities();
	}

}
