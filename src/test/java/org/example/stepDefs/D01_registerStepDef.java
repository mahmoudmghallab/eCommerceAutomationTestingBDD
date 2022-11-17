package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class D01_registerStepDef {

    String msg;
    String complete = "complete";
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {
        register.registerlink().click();
    }


    @When("user select gender type")
    public void selectGenderType() {
        register.selectGender().click();
    }

    @And("user enter first name  and last name")
    public void enterFirstAndLastName() {
        register.writeFirstAndLast("automation", "tester");
    }

    @And("user enter date of birth")
    public void enterDateOfBirth() {

        register.selectDateOfBirthday("13", "April", "1995");
        // register.Page().click();

    }

    @And("user enter email  field")
    public void enterEmailField() {
        register.Email().click();
        register.writeEmail("test@example.com");
    }

    @And("user fills Password fields")
    public void enterPassword() {
        register.writePassword("P@ssw0rd", "P@ssw0rd");

    }

    @And("user clicks on register button")
    public void clickonRegisterBtn() {
        register.RegisterBtn().click();
    }

    @Then("success message is displayed")
    public void success_message_is_displayed() {

        msg= register.GetSuccessMsg().getText();
        Assert.assertTrue(msg.contains(complete));

    }


}



