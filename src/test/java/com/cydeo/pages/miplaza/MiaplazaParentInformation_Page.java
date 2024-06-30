package com.cydeo.pages.miplaza;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MiaplazaParentInformation_Page {

    public MiaplazaParentInformation_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /** Parent Information */

    @FindBy(xpath = "//input[@name='Name' and @type='text']")
    public WebElement parent1FirstName;
    @FindBy(name = "Name1")
    public WebElement parent2FirstName;

    @FindBy(xpath = "//input[@name='Name' and @elname='Last']")
    public WebElement parent1LastName;
    @FindBy(xpath = "//input[@elname='Last' and @name='Name1']")
    public WebElement parent2LastName;

    @FindBy(id = "Email-arialabel")
    public WebElement parent1Email;
    @FindBy(id = "Email1-arialabel")
    public WebElement parent2Email;

    @FindBy(id = "PhoneNumber")
    public WebElement parent1PhoneNumber;
    @FindBy(id = "PhoneNumber1")
    public WebElement parent2PhoneNumber;

    @FindBy(xpath = "//*[@id='Dropdown-arialabel']")
    public WebElement secondParentDropdown;

    @FindBy(xpath = "(//label[@for='Checkbox_1'])[1]")
    public WebElement searchEngine;
    @FindBy(xpath = "(//label[@for='Checkbox_10'])[1]")
    public WebElement otherSocialMedia;

    @FindBy(id = "Date-date")
    public WebElement startDate;

    @FindBy(xpath = "//span[@title='2024']")
    public WebElement year;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement yearField;

    @FindBy(xpath = "//*[.='Aug']")
    public WebElement month;
    @FindBy(xpath = "//*[.='26']")
    public WebElement day;

    @FindBy(xpath = "(//button[@type='button' and @elname='next'])[1]")
    public WebElement nextButton;
    @FindBy(xpath = "//ul[3]//li[1]//div[1]//div[2]//div[1]//button[1]")
    public WebElement nextButton2;

}