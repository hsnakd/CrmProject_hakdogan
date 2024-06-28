package com.cydeo.pages.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Miaplaza_Page {

    public Miaplaza_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Online High School']")
    public WebElement onlineHighSchool;


    @FindBy(xpath = "//*[.='Apply to Our School']")
    public WebElement applyToOurSchool;


    @FindBy(xpath = "//*[.='Next']")
    public WebElement nextButton;


    @FindBy(xpath = "//input[@name='Name' and @type='text']")
    public WebElement parent1FirstName;



    @FindBy(xpath = "//input[@autocomplete='given-name' and @complink='Name2_First']")
    public WebElement student1FirstName;


    @FindBy(xpath = "//input[@name='Name' and @elname='Last']")
    public WebElement parent1LastName;


    @FindBy(id = "Email-arialabel")
    public WebElement parent1Email;



    @FindBy(id = "Email2-arialabel")
    public WebElement student1Email;


    @FindBy(id = "PhoneNumber")
    public WebElement parent1PhoneNumber;


    @FindBy(id = "PhoneNumber2")
    public WebElement parent2PhoneNumber;
}