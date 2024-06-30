package com.cydeo.pages.miplaza;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaOnlineHighSchool_Page {

    public MiaplazaOnlineHighSchool_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /** Online High School */
    @FindBy(xpath = "//*[.='Online High School']")
    public WebElement onlineHighSchool;

}