package com.cydeo.pages.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Miaplaza_Page {

    public Miaplaza_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Online High School
    @FindBy(xpath = "//*[.='Online High School']")
    public WebElement onlineHighSchool;

    // Apply to Our School
    @FindBy(xpath = "//*[.='Apply to Our School']")
    public WebElement applyToOurSchool;



    // Student Information

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

    // Student Information

    @FindBy(id = "Dropdown1-arialabel")
    public WebElement selectStudentNumber;

    @FindBy(xpath = "//input[@autocomplete='given-name' and @complink='Name2_First']")
    public WebElement student1FirstName;
    @FindBy(xpath = "//input[@autocomplete='given-name' and @complink='Name3_First']")
    public WebElement student2FirstName;

    @FindBy(xpath = "//input[@name='Name2' and @elname='Last']")
    public WebElement student1LastName;
    @FindBy(xpath = "//input[@elname='Last' and @name='Name3']")
    public WebElement student2LastName;

    @FindBy(id = "Email2-arialabel")
    public WebElement student1Email;
    @FindBy(id = "Email3-arialabel")
    public WebElement student2Email;

    @FindBy(id = "PhoneNumber2")
    public WebElement student1PhoneNumber;
    @FindBy(id = "PhoneNumber3")
    public WebElement student2PhoneNumber;

    @FindBy(id = "SingleLine3-arialabel")
    public WebElement student1DateOfBirth;
    @FindBy(id = "SingleLine4-arialabel")
    public WebElement student2DateOfBirth;

    @FindBy(id = "Dropdown2-arialabel")
    public WebElement student1Consent;
    @FindBy(id = "Dropdown6-arialabel")
    public WebElement student2Consent;

    @FindBy(id = "Dropdown3-arialabel")
    public WebElement student1Gender;
    @FindBy(id = "Dropdown7-arialabel")
    public WebElement student2Gender;

    @FindBy(id = "Dropdown4-arialabel")
    public WebElement student1Account;
    @FindBy(id = "Dropdown8-arialabel")
    public WebElement student2Account;

    @FindBy(id = "Dropdown10-arialabel")
    public WebElement student1Membership;
    @FindBy(id = "Dropdown8-arialabel")
    public WebElement student2Membership;

    @FindBy(id = "Dropdown5-arialabel")
    public WebElement student1Schooling;
    @FindBy(id = "Dropdown9-arialabel")
    public WebElement student2Schooling;

    @FindBy(xpath = "(//label[@for='Checkbox1_2'])[1]")
    public WebElement student1Math1;
    @FindBy(xpath = "//label[@for='Checkbox1_5']")
    public WebElement student1Math2;

    @FindBy(xpath = "//label[@for='Checkbox2_1']")
    public WebElement student1English1;
    @FindBy(xpath = "//label[@for='Checkbox2_2']")
    public WebElement student1English2;

    @FindBy(xpath = "//label[@for='Checkbox3_1']")
    public WebElement student1Science1;
    @FindBy(xpath = "//label[@for='Checkbox3_3']")
    public WebElement student1Science2;



    @FindBy(xpath = "//label[@for='Checkbox4_1']")
    public WebElement student2Math1;
    @FindBy(xpath = "//label[@for='Checkbox4_3']")
    public WebElement student2Math2;

    @FindBy(xpath = "//label[@for='Checkbox4_3']")
    public WebElement student2English1;
    @FindBy(xpath = "//label[@for='Checkbox5_4']")
    public WebElement student2English2;

    @FindBy(xpath = "//label[@for='Checkbox6_2']")
    public WebElement student2Science1;
    @FindBy(xpath = "//label[@for='Checkbox6_3']")
    public WebElement student2Science2;

    @FindBy(id = "MultiLine-arialabel")
    public WebElement student1List;
    @FindBy(id = "MultiLine2-arialabel")
    public WebElement student2List;

    @FindBy(id = "Dropdown13-arialabel")
    public WebElement student1Needs;
    @FindBy(id = "Dropdown14-arialabel")
    public WebElement student2Needs;

    @FindBy(id = "MultiLine1-arialabel")
    public WebElement student1Describe;







}