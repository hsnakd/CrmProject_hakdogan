package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class selenium4 {

    public selenium4(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "q")
    public WebElement googleSearchBox;

    @FindBy(xpath = "//*[@id=\"gb\"]/div/div[1]/div/div[2]/a")
    public WebElement imageLink;


}
