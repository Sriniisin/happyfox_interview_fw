package StepDefinitions;

import base.SeleniumBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends SeleniumBase{
	
	@Before
	public void browserSetup() {
		startApp("");
	}
	
	@After
	public void teardown() {
		close();
		quit();
	}
}
