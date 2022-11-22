package org.example.stepDefs;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    String msg;
    String color;

    @When("if you click on wishlist button ❤️ on HTC product")
    public void clickOnWishlist() {
        homePage.whichListBtn().click();
    }

    @Then("user will see  success message \"The product has been added to your wishlist\" with green background color")
    public void validateSuccessMsg() {
        msg = homePage.successBar().getText();
        //  System.out.println(msg);
        Assert.assertTrue(msg.contains("product has been added"));
        color = homePage.getColor();

        Assert.assertTrue(color.contains("4bb07a"));
    }

    @Given("wait to success message to disapear")
    public void waitSuccessMessageDisappear() {
        homePage.waitUntilSuccessMessageDisappear();

    }
    @And("go to wishlist page")
    public void clickOnWishList(){
        homePage.wishlistButton().click();
    }
    @Then("Check the quantity of product bigger than 0")
    public void checkQuality(){
        String countNumber =   driver.findElement(By.className("qty-input")).getAttribute("value");

        int inTcount=    Integer.parseInt(countNumber);

        Assert.assertTrue(inTcount>0);
    }

    }
