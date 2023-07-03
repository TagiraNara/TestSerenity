package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.Platform;



public class BasicSteps {
    private EnvironmentVariables environmentVariables;
    Actor user;

    @Managed
    WebDriver hisBrowser;

    MainPage mainPage;

    Platform platformPage;

    @Before
    public void setUp() {
        SerenityRest.reset();
        SerenityRest.setDefaultRequestSpecification(new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new CookieFilter(true))
                .build());
        this.user = Actor.named("Test")
                .whoCan(BrowseTheWeb.with(hisBrowser))
                .whoCan(CallAnApi.at(""));
    }

    @Given("user opens browser on page named {string}")
    public void userWantsToOpenThePage(String page) {
        this.user.attemptsTo(Open.browserOn().thePageNamed(page));
    }

    @Given("user opens browser on page object mainPage")
    public void userWantsToOpenThePageObjectMainPage() {
        this.user.attemptsTo(Open.browserOn().the(mainPage));
    }

    @Given("user opens browser on page object platformPage")
    public void userWantsToOpenThePageObjectPlatform() {
        this.user.attemptsTo(Open.browserOn().the(platformPage));
    }

    @Given("user gets a page named {string}")
    public void userSendsGetRequestToPage(String page) {
        EnvironmentSpecificConfiguration conf = EnvironmentSpecificConfiguration.from(environmentVariables);
        String pageUrl = conf.getOptionalProperty(page).orElse(null);
        this.user.attemptsTo(Get.resource(pageUrl));
    }


}
