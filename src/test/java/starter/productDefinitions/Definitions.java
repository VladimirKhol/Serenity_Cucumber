package starter.productDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.steps.CommonSteps;
import starter.steps.VerificationSteps;

public class Definitions {
    @Steps
    CommonSteps commonSteps;
    @Steps
    VerificationSteps verificationSteps;

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String endpoint) {
        commonSteps.callFor(endpoint);
    }

    @Then("he sees the title {string} in the list of products")
    public void heSeesTheTitle(String title) {
        verificationSteps.isTitlePresent(title);
    }

    @Then("he sees an error message {string}")
    public void heSeesErrorMessage(String errMessage) {
        verificationSteps.isErrorMessagePresent(errMessage);
    }
}