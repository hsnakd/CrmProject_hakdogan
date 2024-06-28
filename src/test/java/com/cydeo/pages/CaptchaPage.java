package com.cydeo.pages;


import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CaptchaPage {


    public CaptchaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // Define locators
//    By captchaFrame = By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]");
//    By captchaCheckbox = By.cssSelector(".recaptcha-checkbox-border");
//    @FindBy(name = "a-lfbdoc72ou7r")
    @FindBy(css = ".recaptcha-checkbox-border")
    public WebElement captchaCheckbox;



    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    public WebElement captchaFrame;


    @FindBy(id = "recaptcha-demo-submit")
    public WebElement submitButton;


    @FindBy(className = "recaptcha-success")
    public WebElement successMessage;


}
