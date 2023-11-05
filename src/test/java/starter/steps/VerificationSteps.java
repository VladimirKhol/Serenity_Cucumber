package starter.steps;

import net.serenitybdd.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class VerificationSteps {

    @Step("Verify that the title {0} is present in the body")
    public void isTitlePresent(String title) {
        restAssuredThat(response -> response.body(containsString(title)));
    }

    @Step("Verify that the error message {0} is appeared")
    public void isErrorMessagePresent(String errMessage) {
        restAssuredThat(response ->
                response.appendRootPath("detail")
                        .body("error", equalTo(true))
                        .and()
                        .body("message", equalTo(errMessage)));
    }

}
