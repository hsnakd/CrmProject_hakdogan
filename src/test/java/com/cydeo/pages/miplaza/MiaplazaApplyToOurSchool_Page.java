package com.cydeo.pages.miplaza;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaApplyToOurSchool_Page {

    public MiaplazaApplyToOurSchool_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /** Apply to Our School */
    @FindBy(xpath = "//*[.='Apply to Our School']")
    public WebElement applyToOurSchool;
}