package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.env.ApplicationProperties;
import starter.env.Environment;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions {
    ApplicationProperties appProps = Environment.INSTANCE.getApplicationProperties();

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String endpoint) {
        given().get(appProps.getBaseURL() + appProps.path() + endpoint);
    }

    @Then("he sees the title {string} in the list of products")
    public void heSeesTheResultsDisplayedFor(String title) {
        restAssuredThat(response -> response.body(containsString(title)));
    }

    @Then("he sees an error message {string}")
    public void heSeesErrorMessage(String errMessage) {
        restAssuredThat(response ->
                response.appendRootPath("detail")
                        .body("error", equalTo(true))
                        .and()
                        .body("message", equalTo(errMessage)));
    }
}