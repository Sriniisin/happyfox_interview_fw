package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/AgentPortal.feature", glue = { "StepDefinitions" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports/report.html", "json:target/JSONReports/report.json",
		"junit:target/JunitReport/report.xml" }, tags = "@sanityTest")
public class TestRunner {

}
