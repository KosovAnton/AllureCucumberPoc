package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class StepDefinitions {

    @Given("I am opening url {string}")
    public void iAmOpeningUrl(String url) {
        open(url);
        $("img[alt='Google']").shouldBe(visible);
    }

    @And("I populate google search field with text {string}")
    public void iPopulateGoogleSearchFieldWithText(String string) {
        $("input[name='q']").shouldBe(interactable).setValue(string);
    }

    @When("I click button 'Google Search'")
    public void iClickButtonGoogleSearch() {
        $$("input[value='Google Search']").find(visible).click();
    }

    @Then("I see that search results contains {string}")
    public void iSeeThatSearchResultsContains(String string) {
        $x("//h1[text()='Search Results']").sibling(0).shouldHave(text(string));
    }
}
