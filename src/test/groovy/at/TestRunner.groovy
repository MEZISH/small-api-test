package at

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
 * Created by Kristaps Mezavilks on 05/03/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "@test", plugin = ["html:build/cucumber/html", "json:build/cucumber/json/report.json", "pretty"])
class TestRunner {
}
