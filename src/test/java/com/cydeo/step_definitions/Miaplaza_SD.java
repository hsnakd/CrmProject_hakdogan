package com.cydeo.step_definitions;

import com.cydeo.pages.CrmProjectTask_Page;
import com.cydeo.pages.pages.Miaplaza_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Miaplaza_SD {

    Miaplaza_Page miaplazaPage = new Miaplaza_Page();


    @Given("The user is on the MiAcademy website")
    public void theUserIsOnTheMiAcademyWebsite() {
        Driver.getDriver().get("https://miacademy.co/#/");
    }

    @When("The user navigates to the MiaPrep Online High School page")
    public void theUserNavigatesToTheMiaPrepOnlineHighSchoolPage() {
        miaplazaPage.onlineHighSchool.click();
    }

    @And("The user clicks on {string}")
    public void theUserClicksOn(String arg0) {
        miaplazaPage.applyToOurSchool.click();
    }

    @And("The user fills in the Parent Information with {string} and {string}")
    public void theUserFillsInTheParentInformationWithAnd(String arg0, String arg1) {
        miaplazaPage.parent1FirstName.sendKeys("arg0");
        miaplazaPage.parent1LastName.sendKeys("arg1");
        miaplazaPage.parent1Email.sendKeys("hakdogan@live.com");
        miaplazaPage.parent1PhoneNumber.sendKeys("+905469562626");
        BrowserUtils.sleep(3);
    }

    @And("The user proceeds to the Student Information page")
    public void theUserProceedsToTheStudentInformationPage() {
    }

    @And("The user fills in the Student Information with {string} and {string}")
    public void theUserFillsInTheStudentInformationWithAnd(String arg0, String arg1) {
    }

    @And("The user submits the application form")
    public void theUserSubmitsTheApplicationForm() {
    }

    @Then("The user should see a confirmation message")
    public void theUserShouldSeeAConfirmationMessage() {
    }
}
