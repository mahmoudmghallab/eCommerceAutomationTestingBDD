package org.example.stepDefs;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D03_currenciesStepDef {

    P03_homePage homePage = new P03_homePage();
    String products;

    @When("user change currency to euro")
    public void changeCurrency() {
        Select currDdl = new Select(driver.findElement(By.id("customerCurrency")));
        currDdl.selectByVisibleText("Euro");

    }
        @Then("Verify euro sign will be displayed in the 4 products on home page")
        public void verifyEuro() {
            List<String> a = new ArrayList<>();
            List<WebElement> items = driver.findElements(By.xpath("//span[@class='price actual-price']"));
            // String items;
            for (int i = 0; i < items.size(); i++) {
                a.add(items.get(i).getText());
                Assert.assertTrue(items.get(i).getText().contains("€"));
               // System.out.println(items.get(i).getText());
            }

        }


    }
