package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("users log in with valid credentials as a {string}")
    public void usersLogInWithValidCredentialsAsA(String userType) {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        switch (userType) {

            case "hr":
                loginPage.username.sendKeys(ConfigurationReader.getProperty("hr.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("hr.password"));
                break;
            case "marketing":
                loginPage.username.sendKeys(ConfigurationReader.getProperty("marketing.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("marketing.password"));
                break;

            case "helpdesk":
                loginPage.username.sendKeys(ConfigurationReader.getProperty("helpdesk.username"));
                loginPage.password.sendKeys(ConfigurationReader.getProperty("helpdesk.password"));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + userType);
        }

        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.activityStream.isDisplayed());

    }



}


