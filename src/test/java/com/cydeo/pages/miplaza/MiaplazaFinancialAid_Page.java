package com.cydeo.pages.miplaza;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaFinancialAid_Page {

    public MiaplazaFinancialAid_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

/** Financial Aid Application */
    @FindBy(id = "Dropdown12-arialabel")
    public WebElement requireFinancialAid;

    @FindBy(id = "SingleLine-arialabel")
    public WebElement householdSize;

    @FindBy(id = "SingleLine1-arialabel")
    public WebElement householdIncome;

    @FindBy(id = "SingleLine2-arialabel")
    public WebElement householdCost;

    @FindBy(id = "MultiLine4-arialabel")
    public WebElement householdBenefit;

    @FindBy(id = "MultiLine5-arialabel")
    public WebElement householdEvidence;


/** Submit the application */
    @FindBy(xpath = "//button[.//em[text()='Submit']]")
    public WebElement submitButton;

}