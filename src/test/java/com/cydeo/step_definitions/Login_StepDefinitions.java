package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Environment;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("users log in with valid credentials as a {string}")
    public void usersLogInWithValidCredentialsAsA(String userType) {

        String email = "";
        String password = "";

        if (!(ConfigurationReader.getProperty("environment").equalsIgnoreCase("null"))) {

            Driver.getDriver().get(Environment.URL);

            switch (userType) {

                case "hr":
                    email = Environment.HR_EMAIL;
                    password = Environment.HR_PASSWORD;
                    break;
                case "marketing":
                    email = Environment.MARKETING_EMAIL;
                    password = Environment.MARKETING_PASSWORD;
                    break;

                case "helpdesk":
                    email = Environment.HELPDESK_EMAIL;
                    password = Environment.HELPDESK_PASSWORD;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + userType);
            }


        } else {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));

            switch (userType) {

                case "hr":
                    email = ConfigurationReader.getProperty("hr.username");
                    password = ConfigurationReader.getProperty("hr.password");
                    break;
                case "marketing":
                    email = ConfigurationReader.getProperty("marketing.username");
                    password = ConfigurationReader.getProperty("marketing.password");
                    break;

                case "helpdesk":
                    email = ConfigurationReader.getProperty("helpdesk.username");
                    password = ConfigurationReader.getProperty("helpdesk.password");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + userType);
            }


        }


        
        loginPage.username.sendKeys(email);
        loginPage.password.sendKeys(password);

        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.activityStream.isDisplayed());

    }


    }
