package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;


public class Locators {

    public Locators(){
        PageFactory.initElements(Driver.getDriver(), this);
/*
    PageFactory class is a Selenium class that support POM

    It has method called initElements.

    Once it's called it will store all elements specified using @FindBy annotation with
    locator and it wll give elements to the classes when they called initElements method
    accept 2 arg

    WebDriver instance and Page class instance (this) means current instance of this class
 */
    }

    /** If you have spaces in your locator's content(text) in HTML,
        you can use "normalize-space()" for text of elements */
    @FindBy (xpath="//a[normalize-space()='Results']")
    public WebElement resultLink;

    /** List<WebElement> */
    @FindBy(name = "card")
    public List<WebElement> cardType;

    //id
    @FindBy(id = "blog-submit-button-save")
    public WebElement id;

    //name
    @FindBy(name = "username")
    public WebElement inputUsername;

    //tagName
    @FindBy(tagName = "blog")
    public WebElement tagName;

    //className
    @FindBy (className = "gauge-speed-text")
    public WebElement className;


    //linkText
    @FindBy(linkText = "blog")
    public WebElement linkText;

    //partialLinkText
    @FindBy(partialLinkText = "blog")
    public WebElement partialLinkText;

    //
    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement spongeBobImage;

    @FindBy(xpath = "//*[@id=\"variation_size_name\"]/div/span")
    public WebElement size;

    //
    @FindBy(xpath = "//td[@class='a-span9']/span")
    public WebElement brand;

    //xpath Known Att&Value
    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement xpath1;

    //xpath Known Value Only
    @FindBy(xpath = "//span[@*='Task']")
    public WebElement xpath2;

    //xpath Known Attribute Only
    @FindBy(xpath = "//*[@data-bx-id='Task']")
    public WebElement xpath3;

    //xpath Known Visible Text
    @FindBy(xpath = "//span[text()='Task']")
    public WebElement xpath4;

    //xpath Known Visible Text
    @FindBy(xpath = "//span[.='Task']")
    public WebElement xpath5;

    //xpath Known Visible Text
    @FindBy(xpath = "//*[.='Task']")
    public WebElement xpath6;

    //xpath contains
    @FindBy(xpath = "//a[contains(text(),'Add more')]")
    public WebElement contains1;

    //xpath contains
    @FindBy(xpath = "//a[contains(@id,'blog-submit-button-save')]")
    public WebElement contains2;

    //contains iframe
    @FindBy(xpath = "//iframe[contains(@id, 'iframe')]")
    public WebElement checklistVerifyIframe;

    //xpath starts-with
    @FindBy(xpath = "//a[starts-with(@id,'blog-submit-button-save')]")
    public WebElement xpathstartswith;

    //xpath ends-with
    @FindBy(xpath = "//a[ends-with(@id,'blog-submit-button-save')]")
    public WebElement xpathendswith;

    //
    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[1]")
    public WebElement addPeople2;


    //Multiple Attributes
    @FindBy(xpath = "//input[@data-bx-id='datepicker-display'] [@class='task-options-inp']")
    public WebElement multipleAttributes;

    //Multiple Attributes and
    @FindBy(xpath = "//input[@data-bx-id='datepicker-display' and @class='task-options-inp']")
    public WebElement multipleAttributesAnd;

    //Multiple Attributes or
    @FindBy(xpath = "//input[@data-bx-id='datepicker-display' or @class='task-options-inp']")
    public WebElement multipleAttributesOr;

    //relative
    @FindBy(xpath = "//table[@class='main-grid-panel-table']//tr/td[2]//span[2]")
    public WebElement count;

    //following-sibling
    @FindBy(xpath = "//div[.='Start:']/following-sibling::div")
    public WebElement followingSibling;

    //followingSibling2
    @FindBy(xpath = "//div[.='Start:']/following-sibling::*")
    public WebElement followingSibling2;

    //parent
    @FindBy(xpath = "//div[.='Start:']/parent::div")
    public WebElement parent;



//CSS

    //@FindBy(xpath = "//p[@id='message']")
    @FindBy(css = "p[id='message']")
    public WebElement message;

    //@FindBy(xpath = "//button[.='Remove']
    @FindBy(css = "form#checkbox-example > button")
    public WebElement removeButton;

    @FindBy(css = "input[type='text']")
    public WebElement inputBox;

    @FindBy(css = "div#loading")
    public WebElement loadingBar;

    @FindBy (css =".result-data-large.number.result-data-value.upload-speed")
    public WebElement uploadSpeed;

    @FindBy(css = "#username")
    public WebElement username;



//    @FindBy(xpath = "//td[contains(text(), 'Minute') or contains (text(), 'Hour')]/../td[1])
//    public List <WebElement> pdfIcons;

    @FindBy(css = "input[id='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[id='password']")
    @FindBys({
            @FindBy(className = "form-group"),
            @FindBy(xpath = "ancestor::div")})
    public WebElement passwordInput;



//    Above
//    If the email text field element is not easily identifiable for some reason, but the password text field element is, we can locate the text field element using the fact that it is an “input” element “above” the password element.
    By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));

//    Below
//    If the password text field element is not easily identifiable for some reason, but the email text field element is, we can locate the text field element using the fact that it is an “input” element “below” the email element.
    By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));

//    Left of
//    If the cancel button is not easily identifiable for some reason, but the submit button element is, we can locate the cancel button element using the fact that it is a “button” element to the “left of” the submit element.
    By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));

//    Right of
//    If the submit button is not easily identifiable for some reason, but the cancel button element is, we can locate the submit button element using the fact that it is a “button” element “to the right of” the cancel element.
    By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));

//    Near
//    If the relative positioning is not obvious, or it varies based on window size, you can use the near method to identify an element that is at most 50px away from the provided locator. One great use case for this is to work with a form element that doesn’t have an easily constructed locator, but its associated input label element does.
    By emailLocator2 = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));

//    Chaining relative locators
//    You can also chain locators if needed. Sometimes the element is most easily identified as being both above/below one element and right/left of another.
    By submitLocator2 = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel"));




}


/*
BASIC LOCATORS

ID				 driver.findElement(By.id(“button1”));
name				 driver.findElement(By.name(“full_name”));
tagName			 driver.findElement(By.tagName(“input”));
className			 driver.findElement(By.tagName(“nav-link”));
linkText			 driver.findElement(By.linkText(“Example4: Element on page”));
partialLinkText			 driver.findElement(By.partialLinkText(“Example4”));

                                XPATH

Known Att&Value		             //tagName[@attribute=’value’]
Known Value Only		         //tagName[@*=’value’]
Known Visible Text		         //tagName[text()=’exact text’]
			  	                 //tagName[.=’exact text’]
			   	                 //*[text()=’exact text’]
				                 //*[.=’exact text’]
Known Visible Text (Partial)	 //tagName[contains(text(),’exact text’)]
Dynamic Element (Contains)	     //tagName[contains(@attribute,’value’)]
Dynamic Element (Startswith)	 //tagName[startswith(@attribute,’value’)]
Dynamic Element (Endswith)	     //tagName[endswith(@attribute,’value’)]
With Multiple Attributes	     //tagName[@attribute1=’value1’] [@attribute2=’value2’]
                                 //tagName[@attribute1=’value1’ and @attribute2=’value2’]
                                 //tagName[@attribute1=’value1’] or @attribute2=’value2’]
Relative to Known Element	     //<Known part>/parent::*
				                 //<Known part>/parent::tagName
				                 //<Known part>/following-sibling::*
				                 //<Known part>/following-sibling::tagName



                                CSS

ID				                 tagName#idValue
				                 #idValue
className			             tagName.classValue
				                 .classValue
				                 tagName.btn.btn-primary
Known Att&Value		             tagName[attribute=’value’]
				                 [attribute=’value’]
Dynamic Element (Contains)	     tagName[ attribute*,’value’]
Dynamic Element (Startswith)	 tagName[ attribute^,’value’]
Dynamic Element (Endswith)	     tagName[ attribute$,’value’]
If Multiple Results		         <CSS>:nth-of-type(index)
Multiple Attributes		         tagName[attribute1=’value1’] [attribute2=’value2’]
Child Element			         tag > tag > tag
Parent Element			         tag tag tag
Sibling Element			         <CSS>~tagName




 */