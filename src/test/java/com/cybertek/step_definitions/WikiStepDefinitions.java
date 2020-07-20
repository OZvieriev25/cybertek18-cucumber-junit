package com.cybertek.step_definitions;

import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiStepDefinitions {
    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User in on the Wikipedia home page")
    public void user_in_on_the_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }

    @When("User searches {string} in the wiki search page")
    public void user_searches_in_the_wiki_search_page(String input) {
        wikiSearchPage.searchBox.sendKeys(input);
        wikiSearchPage.searchButton.click();
    }

    @Then("User should see {string} in the wiki title")
    public void user_should_see_in_the_wiki_title(String input) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(input));

    }

    @Then("User should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String input) {
        String actualHeaderText = wikiSearchPage.mainHeaderAfterSearch.getText();
        Assert.assertEquals(actualHeaderText, input);
    }

    @Then("User should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String input) {
        String actualImageText = wikiSearchPage.imageHeaderAfterSearch.getText();
        Assert.assertEquals(actualImageText, input);
    }
}
