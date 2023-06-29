package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.Platform;


public class BasicSteps {
    Actor user;

    @Managed
    WebDriver hisBrowser;

    MainPage mainPage;

    Platform platformPage;

    @Before
    public void setUp() {
        this.user = Actor.named("Test").whoCan(BrowseTheWeb.with(hisBrowser));
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


}
