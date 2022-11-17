package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class P03_homePage {
    public WebElement firstSlider()
    {

        return driver.findElement(By.cssSelector("div[id=“nivo-slider”] a[class=“nivo-imageLink”]:nth-child(1)"));

    }

    public WebElement Secondslider(){
        return driver.findElement(By.cssSelector("div[id=“nivo-slider”] a[class=“nivo-imageLink”]:nth-child(2)"));
    }
    public String getURL()
    {
        return driver.getCurrentUrl();

    }
    public WebElement facebookBtn(){

        return driver.findElement(By.className("facebook"));
    }
    public WebElement clickOnFacebookBtn(){

        return driver.findElement(By.className("facebook"));

      //  ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());


    }
    public WebElement twitterBtn(){

        return driver.findElement(By.className("twitter"));
    }


    public WebElement rssBtn(){

        return driver.findElement(By.className("rss"));
    }
    public WebElement youtubeBtn(){

        return driver.findElement(By.className("youtube"));
    }
}
