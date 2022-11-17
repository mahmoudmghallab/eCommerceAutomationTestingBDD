package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;


public class D06_homeSlidersStepDef {

    P03_homePage homePage = new P03_homePage();
String newURL;
WebElement firstSlider;

    @Given("user click on first slider on home page")
    public void clickOnFirstSlider(){

        firstSlider = homePage.firstSlider();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofMillis(1000));
      //  wait.until(ExpectedConditions.attributeToBe(homePage.firstSlider(),“style”,“display: block;”));
        wait.until(ExpectedConditions.presenceOfElementLocated((By) firstSlider));


        homePage.firstSlider().click();

        newURL = homePage.getURL();

       Assert.assertTrue(newURL.contains("https://demo.nopcommerce.com/nokia-lumia-1020"));


}
}