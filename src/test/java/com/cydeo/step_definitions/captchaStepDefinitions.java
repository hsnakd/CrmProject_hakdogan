package com.cydeo.step_definitions;

import com.cydeo.pages.CaptchaPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class captchaStepDefinitions {
    CaptchaPage captchaPage = new CaptchaPage();

    @Given("I am on the vote page")
    public void i_am_on_the_vote_page() {

        Driver.getDriver().get("https://www.orangehrm.com/en/30-day-free-trial");
//        Driver.getDriver().get("https://www.google.com/recaptcha/api2/demo");
    }

    @When("I click the captcha checkbox")
    public void i_click_the_captcha_checkbox() {
        BrowserUtils.sleep(1);

        Driver.getDriver().switchTo().frame(captchaPage.captchaFrame);
//        BrowserUtils.switchToIFrame(1);
//        System.out.println("captchaPage.captchaFrame.getText() = " + captchaPage.captchaFrame.getText());
//        BrowserUtils.sleep(1);
        captchaPage.captchaCheckbox.click();
//        BrowserUtils.clickCaptchaCheckbox(captchaPage.captchaFrame, captchaPage.captchaCheckbox); //
        BrowserUtils.sleep(30);
//        captchaPage.submitButton.click();




    }

    @Then("I should see the captcha is checked")
    public void i_should_see_the_captcha_is_checked() {
        // Add assertion to verify captcha checkbox is checked
        // Note: Actual implementation might differ based on the captcha's behavior and state verification
        System.out.println("captchaPage.successMessage = " + captchaPage.successMessage.getText());
//        assertEquals("recaptcha-success", captchaPage.successMessage); // This is a placeholder. Replace with actual verification.

    }
}

