package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseSetup;
import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgentPortalSteps extends BaseSetup{
	
	WebDriver driver;
	
//	public AgentPortalSteps() {
//		this.driver = getDriver();
//	}
	
	loginPage login;

	@Given("^login to (.*) with agent (.*) and (.*)$")
	public void login_to_url_with_agent_credentials(String url, String un, String pw) {
		System.out.println("Passed");
		login = new loginPage(driver);
		login.navigateToUrl(url);
		login.enterUsername(un);
		login.enterPassword(pw);
		login.clickLoginButton();
	}

	@And("^navigate to Status Page$")
	public void some_other_precondition() {
		System.out.println("Passed");

	}

	@When("^I create a new status$")
	public void i_complete_action() {
		System.out.println("Passed");

	}

	@Then("^the new status should be available in the list$")
	public void i_validate_the_outcomes() {
		System.out.println("Passed");

	}

}
