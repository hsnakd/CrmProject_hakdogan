package com.cydeo.step_definitions;

import com.cydeo.pages.CrmProjectTask_Page;
import com.cydeo.pages.pages.Miaplaza_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Miaplaza_SD {

    Miaplaza_Page miaplazaPage = new Miaplaza_Page();
    Faker faker = new Faker();

    @Given("The user is on the MiAcademy website")
    public void theUserIsOnTheMiAcademyWebsite() {
        Driver.getDriver().get("https://miacademy.co/#/");
//        Driver.getDriver().get("https://forms.zohopublic.com/miaplazahelp/form/MOHSInitialApplication/formperma/okCyt4yyq39rZvSBXB9FSjDeek1ilbRVK1iNCK--3K8");
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
//        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
//        selectState.selectByValue("CA");
//        selectState.selectByVisibleText("California");
//        selectState.selectByIndex(5);

        // Parent Information
        miaplazaPage.parent1FirstName.sendKeys(faker.name().firstName());
        miaplazaPage.parent1LastName.sendKeys(faker.name().lastName());
        miaplazaPage.parent1Email.sendKeys(faker.internet().emailAddress());
        miaplazaPage.parent1PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        Select secondParentDropdown = new Select(miaplazaPage.secondParentDropdown);
        secondParentDropdown.selectByVisibleText("Yes");

        // Second Parent Information
        miaplazaPage.parent2FirstName.sendKeys(faker.name().firstName());
        miaplazaPage.parent2LastName.sendKeys(faker.name().lastName());
        miaplazaPage.parent2Email.sendKeys(faker.internet().emailAddress());
        miaplazaPage.parent2PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        // How did you hear about us? (Select all that apply)
        miaplazaPage.searchEngine.click();
//        assertTrue(miaplazaPage.searchEngine.isSelected());
        miaplazaPage.otherSocialMedia.click();
//        assertTrue(miaplazaPage.otherSocialMedia.isSelected());

        // What is your preferred start date? *
        miaplazaPage.startDate.click();
        miaplazaPage.year.click();
        miaplazaPage.yearField.sendKeys("2024");

        miaplazaPage.month.click();

        miaplazaPage.day.click();

        // Click the Next Button
        miaplazaPage.nextButton.click();

        BrowserUtils.sleep(5);


    }

    @And("The user proceeds to the Student Information page")
    public void theUserProceedsToTheStudentInformationPage() {

        BrowserUtils.sleep(2);
        Select secondParentDropdown = new Select(miaplazaPage.selectStudentNumber);
        secondParentDropdown.selectByVisibleText("Two");

        /** Student Information */
        miaplazaPage.student1FirstName.sendKeys(faker.name().firstName());
        miaplazaPage.student1LastName.sendKeys(faker.name().lastName());
        miaplazaPage.student1Email.sendKeys(faker.internet().emailAddress());
        miaplazaPage.student1PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        Select student1Consent = new Select(miaplazaPage.student1Consent);
        student1Consent.selectByVisibleText("Yes");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String student1DateOfBirth = sdf.format(faker.date().birthday(10,18));
        miaplazaPage.student1DateOfBirth.sendKeys(student1DateOfBirth);

        Select student1Gender = new Select(miaplazaPage.student1Gender);
        student1Gender.selectByVisibleText("Male");

        Select student1Account = new Select(miaplazaPage.student1Account);
        student1Account.selectByVisibleText("Yes");

        Select student1Membership = new Select(miaplazaPage.student1Membership);
        student1Membership.selectByVisibleText("Monthly");

        Select student1Schooling = new Select(miaplazaPage.student1Schooling);
        student1Schooling.selectByVisibleText("Private School");

        // For each subject area, check off courses this student has already completed and earned credit for.
        miaplazaPage.student1Math1.click();
        miaplazaPage.student1Math2.click();
        miaplazaPage.student1English1.click();
        miaplazaPage.student1English2.click();
        miaplazaPage.student1Science1.click();
        miaplazaPage.student1Science2.click();

        miaplazaPage.student1List.sendKeys(faker.lorem().paragraph());

        Select student1Needs = new Select(miaplazaPage.student1Needs);
        student1Needs.selectByVisibleText("Yes");

        miaplazaPage.student1Describe.sendKeys(faker.lorem().paragraph());



        /** Student Two */
        miaplazaPage.student2FirstName.sendKeys(faker.name().firstName());
        miaplazaPage.student2LastName.sendKeys(faker.name().lastName());
        miaplazaPage.student2Email.sendKeys(faker.internet().emailAddress());
        miaplazaPage.student2PhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        Select student2Consent = new Select(miaplazaPage.student2Consent);
        student2Consent.selectByVisibleText("No");

        String student2DateOfBirth = sdf.format(faker.date().birthday(10,18));
        miaplazaPage.student2DateOfBirth.sendKeys(student2DateOfBirth);

        Select student2Gender = new Select(miaplazaPage.student2Gender);
        student2Gender.selectByVisibleText("Female");

        Select student2Account = new Select(miaplazaPage.student2Account);
        student2Account.selectByVisibleText("No");

//        Select student2Membership = new Select(miaplazaPage.student2Membership);
//        student2Membership.selectByVisibleText("Monthly");

        Select student2Schooling = new Select(miaplazaPage.student2Schooling);
        student2Schooling.selectByVisibleText("Homeschool");

        // For each subject area, check off courses this student has already completed and earned credit for.
        miaplazaPage.student2Math1.click();
        miaplazaPage.student2Math2.click();
        miaplazaPage.student2English1.click();
        miaplazaPage.student2English2.click();
        miaplazaPage.student2Science1.click();
        miaplazaPage.student2Science2.click();

        miaplazaPage.student2List.sendKeys(faker.lorem().paragraph());

        Select student2Needs = new Select(miaplazaPage.student2Needs);
        student2Needs.selectByVisibleText("No");

//        miaplazaPage.student2Describe.sendKeys(faker.lorem().paragraph());


        BrowserUtils.sleep(15);
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
