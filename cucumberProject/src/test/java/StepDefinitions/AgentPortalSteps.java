package StepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.homePage;
import Pages.loginPage;
import Pages.priorityPage;
import Pages.statusPage;
import Pages.ticketPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgentPortalSteps {

	WebDriver driver;
	
	loginPage login;
	homePage home;
	statusPage status;
	priorityPage priority;
	ticketPage ticket;

	@Given("^login to (.*) with agent (.*) and (.*)$")
	public void login_to_url_with_agent_credentials(String url, String un, String pw) {
		try {
			login = new loginPage();
			login.navigateToUrl(url);
			login.enterUsername(un);
			login.enterPassword(pw);
			login.clickLoginButton();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@And("navigate to Status Page")
	public void navigate_to_status_page() {
		home = new homePage();
		home.clickStatuses();
	}

	@When("^I create a new status with (.*),(.*) and (.*)$")
	public void i_create_a_new_status(String name, String behaviour, String description) {
		status = new statusPage();
		status.addNewStatus();
		status.addStatusDetails(name, behaviour, description);
	}

	@Then("^the new status with (.*) should be available in the list$")
	public void the_new_status_should_be_available_in_the_list(String name) {
		Boolean state = false;
		if(status.checkStatus()) {
			state = true;
		}
		assertTrue("Adding new state failed because of internal server error", state);
	}
	
	@And("navigate to Priority Page")
	public void navigate_to_priority_page() {
		status = new statusPage();
		status.clickPriorities();
	}
	
	@When("^I create a new priority with (.*) and (.*)$")
	public void i_create_a_new_priority(String name, String description) {
		priority = new priorityPage();
		priority.addNewStatus();
		priority.addPriorityDetails(name, description);
	}

	@Then("^the new priority with (.*) should be available in the list$")
	public void the_new_priority_should_be_available_in_the_list(String name) {
		Boolean state = false;
		if(priority.checkPriority()) {
			state = true;
		}
		assertTrue("Adding new priority failed because of internal server error", state);
	}
	
	@And("^I make created Status with as default$")
	public void make_default_status() {
		status = new statusPage();
		status.makeStatusDefault();
		Boolean state = false;
		if(status.checkDefaultIcon()) {
			state = true;
		}
		assertTrue("Priority is not made default", state);
		
		status.clickPriorities();
	}
	
	@And("^I make created Priority with as default$")
	public void make_default_priority() {
		priority = new priorityPage();
		priority.makePriorityDefault();
		Boolean state = false;
		if(priority.checkDefaultIcon()) {
			state = true;
		}
		assertTrue("Priority is not made default", state);
	}
	
	@And("^create a new ticket with details (.*), (.*), (.*), (.*)$")
	public void create_a_new_ticket(String name, String email, String subject, String message) {
		priority = new priorityPage();
		priority.clickCreateTicket();
		priority.enterTicketDetails(name, email, subject, message);
	}
	
	@Then("^check the priority value of the ticket$")
	public void check_priority_value() {
		ticket = new ticketPage();
		Boolean state = false;
		if(ticket.checkPriorityValueOfTicket("Assistance required")) {
			state = true;
		}
		assertTrue("Default priority is not added to ticket", state);
	}
	
	@And("^Reply with the canned actions$")
	public void reply_with_canned_actions() {
		ticket = new ticketPage();
		ticket.clickReply();
		ticket.sendReplyWithCannedActionsMessage();
		Boolean state = false;
		if(ticket.checkUpdatedTicketState()) {
			state = true;
		}
		assertTrue("Ticket not updated", state);
	}
	
	@And("^deletes the created status$")
	public void deletes_the_created_status() {
		status = new statusPage();
		status.clickStatus();
		status.deleteStatus();
	}
	
	@And("^deletes the created priority$")
	public void deletes_the_created_priority() {
		priority = new priorityPage();
		priority.clickPriority();
		priority.deletePriority();
	}
	
	@And("^Logout from the application$")
	public void deletes_the_create_priority() {
		priority = new priorityPage();
		priority.Logout();
	}
	
	@Then("^User should be logged out$")
	public void user_should_beLogged_out() {
		login = new loginPage();
		login.verifyLoginPage();
	}
}
