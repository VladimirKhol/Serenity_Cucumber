package starter.steps;

import env.ApplicationProperties;
import env.Environment;
import net.serenitybdd.annotations.Step;
import starter.Callable;

import static net.serenitybdd.rest.SerenityRest.given;

public class CommonSteps implements Callable {
    ApplicationProperties appProps = Environment.INSTANCE.getApplicationProperties();

    @Step("He calls endpoint {0}")
    @Override
    public void callFor(String endpoint) {
        given().get(appProps.getBaseURL() + appProps.path() + endpoint);
    }
}
