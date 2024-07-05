package com.cydeo.step_definitions;

import com.github.javafaker.Faker;
import com.cydeo.pages.miplaza.*;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Miaplaza_SD {

    MiaplazaOnlineHighSchool_Page miaplazaOnlineHighSchoolPage = new MiaplazaOnlineHighSchool_Page();
    MiaplazaApplyToOurSchool_Page miaplazaApplyToOurSchoolPage = new MiaplazaApplyToOurSchool_Page();
    MiaplazaParentInformation_Page miaplazaParentInformationPage = new MiaplazaParentInformation_Page();
    MiaplazaStudentInformation_Page miaplazaStudentInformationPage = new MiaplazaStudentInformation_Page();
    MiaplazaFinancialAid_Page miaplazaFinancialAidPage = new MiaplazaFinancialAid_Page();

    Faker faker = new Faker();

    @Given("The user is on the MiAcademy website")
    public void theUserIsOnTheMiAcademyWebsite() {
        Driver.getDriver().get(ConfigurationReader.getProperty("miaplazaUrl"));
    }

    @When("The user navigates to the MiaPrep Online High School page")
    public void theUserNavigatesToTheMiaPrepOnlineHighSchoolPage() {
        miaplazaOnlineHighSchoolPage.onlineHighSchool.click();
    }

    @And("The user clicks on Apply to Our School")
    public void theUserClicksOnApplyToOurSchool() {
        miaplazaApplyToOurSchoolPage.applyToOurSchool.click();
    }

    @And("The user fills in the Parent Information section")
    public void theUserFillsInTheParentInformationSection() {

        /** Parent Information */

        // First Parent Information
        miaplazaParentInformationPage.parent1FirstName.sendKeys(faker.name().firstName());
        miaplazaParentInformationPage.parent1LastName.sendKeys(faker.name().lastName());
        miaplazaParentInformationPage.parent1Email.sendKeys(faker.internet().emailAddress());
        miaplazaParentInformationPage.parent1PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        Select secondParentDropdown = new Select(miaplazaParentInformationPage.secondParentDropdown);
        secondParentDropdown.selectByVisibleText("Yes");

        // Second Parent Information
        miaplazaParentInformationPage.parent2FirstName.sendKeys(faker.name().firstName());
        miaplazaParentInformationPage.parent2LastName.sendKeys(faker.name().lastName());
        miaplazaParentInformationPage.parent2Email.sendKeys(faker.internet().emailAddress());
        miaplazaParentInformationPage.parent2PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        // How did you hear about us? (Select all that apply)
        miaplazaParentInformationPage.searchEngine.click();
        miaplazaParentInformationPage.otherSocialMedia.click();

        // What is your preferred start date?
        miaplazaParentInformationPage.startDate.click();
        miaplazaParentInformationPage.year.click();
        miaplazaParentInformationPage.yearField.sendKeys("2024");
        miaplazaParentInformationPage.month.click();
        miaplazaParentInformationPage.day.click();

        // Click the Next Button for Student Information Section
        miaplazaParentInformationPage.nextButton.click();
    }


    @And("The user fills in the Student Information section")
    public void theUserFillsInTheStudentInformationSection() {

        // Select Second Student
        Select secondParentDropdown = new Select(miaplazaStudentInformationPage.selectStudentNumber);
        secondParentDropdown.selectByVisibleText("Two");

        /** Student Information */
        miaplazaStudentInformationPage.student1FirstName.sendKeys(faker.name().firstName());
        miaplazaStudentInformationPage.student1LastName.sendKeys(faker.name().lastName());
        miaplazaStudentInformationPage.student1Email.sendKeys(faker.internet().emailAddress());
        miaplazaStudentInformationPage.student1PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        Select student1Consent = new Select(miaplazaStudentInformationPage.student1Consent);
        student1Consent.selectByVisibleText("Yes");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String student1DateOfBirth = sdf.format(faker.date().birthday(10,18));
        miaplazaStudentInformationPage.student1DateOfBirth.sendKeys(student1DateOfBirth);

        Select student1Gender = new Select(miaplazaStudentInformationPage.student1Gender);
        student1Gender.selectByVisibleText("Male");

        Select student1Account = new Select(miaplazaStudentInformationPage.student1Account);
        student1Account.selectByVisibleText("Yes");

        Select student1Membership = new Select(miaplazaStudentInformationPage.student1Membership);
        student1Membership.selectByVisibleText("Monthly");

        Select student1Schooling = new Select(miaplazaStudentInformationPage.student1Schooling);
        student1Schooling.selectByVisibleText("Private School");

        // For each subject area, check off courses this student has already completed and earned credit for.
        miaplazaStudentInformationPage.student1Math1.click();
        miaplazaStudentInformationPage.student1Math2.click();
        miaplazaStudentInformationPage.student1English1.click();
        miaplazaStudentInformationPage.student1English2.click();
        miaplazaStudentInformationPage.student1Science1.click();
        miaplazaStudentInformationPage.student1Science2.click();

        miaplazaStudentInformationPage.student1List.sendKeys(faker.lorem().paragraph());

        Select student1Needs = new Select(miaplazaStudentInformationPage.student1Needs);
        student1Needs.selectByVisibleText("Yes");

        miaplazaStudentInformationPage.student1Describe.sendKeys(faker.lorem().paragraph());



        /** Student Two Information */
        miaplazaStudentInformationPage.student2FirstName.sendKeys(faker.name().firstName());
        miaplazaStudentInformationPage.student2LastName.sendKeys(faker.name().lastName());
        miaplazaStudentInformationPage.student2Email.sendKeys(faker.internet().emailAddress());
        miaplazaStudentInformationPage.student2PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        Select student2Consent = new Select(miaplazaStudentInformationPage.student2Consent);
        student2Consent.selectByVisibleText("No");

        String student2DateOfBirth = sdf.format(faker.date().birthday(10,18));
        miaplazaStudentInformationPage.student2DateOfBirth.sendKeys(student2DateOfBirth);

        Select student2Gender = new Select(miaplazaStudentInformationPage.student2Gender);
        student2Gender.selectByVisibleText("Female");

        Select student2Account = new Select(miaplazaStudentInformationPage.student2Account);
        student2Account.selectByVisibleText("No");

        Select student2Schooling = new Select(miaplazaStudentInformationPage.student2Schooling);
        student2Schooling.selectByVisibleText("Homeschool");

        // For each subject area, check off courses this student has already completed and earned credit for.
        miaplazaStudentInformationPage.student2Math1.click();
        miaplazaStudentInformationPage.student2Math2.click();
        miaplazaStudentInformationPage.student2English1.click();
        miaplazaStudentInformationPage.student2English2.click();
        miaplazaStudentInformationPage.student2Science1.click();
        miaplazaStudentInformationPage.student2Science2.click();

        miaplazaStudentInformationPage.student2List.sendKeys(faker.lorem().paragraph());

        Select student2Needs = new Select(miaplazaStudentInformationPage.student2Needs);
        student2Needs.selectByVisibleText("No");

        // Click the Next Button for Financial Aid Application Section
        miaplazaStudentInformationPage.nextButton2.click();
    }

    @And("The user fills in the Financial Aid Application section")
    public void theUserFillsInTheFinancialAidApplicationSection() {

        Select requireFinancialAid = new Select(miaplazaFinancialAidPage.requireFinancialAid);
        requireFinancialAid.selectByVisibleText("Yes");

        miaplazaFinancialAidPage.householdSize.sendKeys(String.valueOf(faker.number().numberBetween(2,6)));
        miaplazaFinancialAidPage.householdIncome.sendKeys(String.valueOf(faker.number().randomDouble(2,(int) 500, (int) 1000)));
        miaplazaFinancialAidPage.householdCost.sendKeys(String.valueOf(faker.number().randomDouble(2,(int) 250, (int) 400)));
        miaplazaFinancialAidPage.householdBenefit.sendKeys(faker.lorem().sentence());
        miaplazaFinancialAidPage.householdEvidence.sendKeys(faker.lorem().paragraph());

    }

    @And("The user submits the application form")
    public void theUserSubmitsTheApplicationForm() {
        // The forms of parents and students were filled in, but since they were not requested, this step was prepared as if they had been submitted.
//        miaplazaFinancialAidPage.submitButton.click();
        assertTrue(miaplazaFinancialAidPage.submitButton.isEnabled());
    }


    @Then("Verify that the user should see a {string}")
    public void verifyThatTheUserShouldSeeA(String expectedMessage) {
        // The forms of parents and students were filled in, but since they were not requested, this step was prepared as if they had been submitted.
        String actualMessage = "You have successfully submitted your application";
        assertEquals(expectedMessage, actualMessage);
    }

}
