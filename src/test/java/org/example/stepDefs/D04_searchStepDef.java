package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D04_searchStepDef {

    String currentURL;
    String searchText;
    String SKU;

    P03_homePage homePage = new P03_homePage();

    @When("user search on  \"(.*)\"$")
    public void searchOnProduct(String product) {
        searchText = homePage.writeProductNameOnSearchBox(product);
        homePage.searchBox().sendKeys(Keys.ENTER);
        currentURL = homePage.getURL();
    }

    @Then("Verify URL")
    public void verifyURL() {
        Assert.assertTrue(currentURL.contains("https://demo.nopcommerce.com/search?q="));
    }

    @And("verify each result contains the search word")
    public void verifyEachResult() {
        List<String> products = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("search-results"));
        // String items;
        for (int i = 0; i < items.size(); i++) {
            products.add(items.get(i).getText());
            // junit.framework.Assert.assertTrue(items.get(i).getText().contains(homePage.writeProductNameOnSearchBox(searchText)));
            // System.out.println(items.get(i).getText());
            Assert.assertTrue(items.get(i).getText().toLowerCase().contains(searchText));


        }
    }
        @Given("user search with \"(.*)\"$")
        public void searchOnSKU (String SKU) {
            searchText = homePage.writeProductNameOnSearchBox(SKU);
            homePage.searchBox().sendKeys(Keys.ENTER);currentURL = homePage.getURL();
        }
        @When("user clicks on the product")
      public void clickOnTheProduct(){
    homePage.productImage().click();
        }
        @Then("verify result contains the search word")
        public void verifyResultsContainSKU() {

            String description = homePage.productDesc().getText();
            Assert.assertTrue(description.contains(searchText));

        }
    }
