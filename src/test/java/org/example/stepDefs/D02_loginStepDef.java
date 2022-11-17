package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.testng.Assert;

import java.net.URL;

public class D02_loginStepDef {

    String URL;
    String errorMsg;
    P02_login login = new P02_login();


@Given("user go to login page")
public void userGoToLoginPage(){
login.clickOnLogIn().click();
}
@When("user login with  \"(.*)\" and \"(.*)\"$")
    public void userLoginValid(String email,String password){
    login.writeEmailAndPasssword(email, password);
}
@And("user press on login button")
    public void clickOnLogin(){
    login.clickOnLogInBtn().click();
}
@Then("user login to the system successfully")
    public void loginToSystemSuccessfully(){
    URL = login.getURL();
    Assert.assertTrue(URL.contains("https://demo.nopcommerce.com/"));
}
@Then("user could not login to the system")
    public void couldNotLoginToTheSytem(){

        errorMsg =login.getErrorMsg().getText();
    Assert.assertTrue(errorMsg.contains("Login was unsuccessful"));

    }

}

