package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
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
        $$("center input").shouldHave(sizeGreaterThanOrEqual(2)).filter(visible)
                .find(attributeMatching("value", "^.*Google$")).click();
    }

    @Then("I see that search results contains {string}")
    public void iSeeThatSearchResultsContains(String string) {
        $("div[id='rso']").shouldHave(text(string));
    }
}
