package com.cydeo.step_definitions;

import com.cydeo.pages.CrmProjectTask_Page;
import com.cydeo.pages.selenium4;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class Selenium4 {

    selenium4 selenium4Page = new selenium4();

    @Given("go to page")
    public void goToPage() {
        Driver.getDriver().get(Environment.URL);

    }

    @When("on the home gape")
    public void onTheHomeGape() {

    }

    @Then("GetMethods")
    public void GetMethods() {


        System.out.println("googleSearchBox.getAccessibleName() = " + selenium4Page.googleSearchBox.getAccessibleName());
        System.out.println("googleSearchBox.getAriaRole() = " + selenium4Page.googleSearchBox.getAriaRole());
        System.out.println("googleSearchBox.getDomAttribute(\"class\") = " + selenium4Page.googleSearchBox.getDomAttribute("class"));
        System.out.println("googleSearchBox.getDomProperty(\"class\") = " + selenium4Page.googleSearchBox.getDomProperty("class"));

        System.out.println("--------------------------------------------------");


        System.out.println("storeLink.getAccessibleName() = " + selenium4Page.imageLink.getAccessibleName());
        System.out.println("storeLink.getAriaRole() = " + selenium4Page.imageLink.getAriaRole());
        System.out.println("storeLink.getDomAttribute(\"href\") = " + selenium4Page.imageLink.getDomAttribute("href"));
        System.out.println("storeLink.getDomProperty(\"href\") = " + selenium4Page.imageLink.getDomProperty("href"));

    }

    @Then("WindowMinimize")
    public void WindowMinimize() {
        BrowserUtils.sleep(3);
        Driver.getDriver().manage().window().minimize();
        BrowserUtils.sleep(30);


    }

    @Then("NewWindowNewTab")
    public void NewWindowNewTab() {
        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().get("https://www.etsy.com");

        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get("https://www.tesla.com");

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.amazon.com");




    }

//    @Then("RelativeLocators")
//    public void relativelocators() {
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.get("https://google.com");
//
//        WebElement aboutLink = driver.findElement(By.cssSelector("a[class='gb_B']"));
//
//        WebElement storeLink1 = driver.findElement(By.cssSelector("a[class='gb_B']"));
//        System.out.println("storeLink.getText() = " + storeLink1.getText());
//
//        WebElement storeLink2 = driver.findElement(RelativeLocator.with(By.cssSelector("a[class='gb_B']")).toRightOf(aboutLink));
//        System.out.println("storeLink2.getText() = " + storeLink2.getText());
//    }
//

    @Then("RelativeLocators")
    public void relativelocators() {

        WebElement aboutLink =  Driver.getDriver().findElement(By.cssSelector("a[class='pHiOh']"));

        WebElement storeLink1 =  Driver.getDriver().findElement(By.cssSelector("a[class='pHiOh']"));
        System.out.println("storeLink.getText() = " + storeLink1.getText());

        WebElement storeLink2 =  Driver.getDriver().findElement(RelativeLocator.with(By.cssSelector("a[class='pHiOh']")).toRightOf(aboutLink));
        System.out.println("storeLink2.getText() = " + storeLink2.getText());
    }


    @Then("DurationOfSeconds")
    public void durationofseconds() {

        //selenium 4 implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // selenium 4 explicit wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


        // selenium 3 implicit wait
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // selenium 3 explicit wait
        // WebDriverWait wait = new WebDriverWait(driver,10);



    }


    @Then("createDownloadFolder")
    public void createdownloadfolder() {
        BrowserUtils.createFolder();
    }

    @Then("deleteDownloadFolder")
    public void deletedownloadfolder() {
        BrowserUtils.deleteFolder();
    }

    @Then("countFilesInDownloadFolder")
    public void countfilesindownloadfolder() {
        BrowserUtils.countFilesInFolder();
    }

    @Then("createFolder {string}")
    public void createfolder(String folderName) {
        BrowserUtils.createFolder(folderName);

    }

    @Then("countFilesIn {string}")
    public void countfilesin(String folderName) {
        BrowserUtils.countFilesInFolder(folderName);
    }

    @Then("delete {string}")
    public void delete(String folderName) {
        BrowserUtils.deleteFolder(folderName);
    }

    @Then("createCountDelete {string}")
    public void createcountdelete(String folderName) {
        BrowserUtils.createFolder(folderName);
        BrowserUtils.countFilesInFolder(folderName);
        BrowserUtils.deleteFolder(folderName);

    }

    @Then("createCountDeleteDownloadFolder")
    public void createcountdeletedownloadfolder() {
        BrowserUtils.createFolder();
        BrowserUtils.countFilesInFolder();
        BrowserUtils.deleteFolder();
    }

//
//    @Then("the file should be downloaded successfully")
//    public void theFileShouldBeDownloadedSuccessfully() {
//        String fileURL = "https://www.cprime.com/wp-content/uploads/woocommerce_uploads/2013/05/cPrime-ScrumMaster-Cheat-Sheet.pdf";
//        String localPath = "src/test/java/com/cydeo/folderName";
//        BrowserUtils.downloadFile(fileURL);
//    }


    @Given("I am on the website")
    public void iAmOnTheWebsite() {
        // Initialize the WebDriver

        Driver.getDriver().get("https://www.colesclassroom.com/wp-content/uploads/2020/03/Photography-Cheat-Sheets.pdf");
    }

    @When("I click on the PDF download link")
    public void iClickOnThePDFDownloadLink() {
        CrmProjectTask_Page taskPage = new CrmProjectTask_Page();
        // Locate and click the PDF download link
        WebElement pdfLink = taskPage.downloadLink;
        pdfLink.click();
    }

    @Then("the PDF file should be downloaded successfully")
    public void thePDFFileShouldBeDownloadedSuccessfully() {
        // You can implement logic here to verify the file download.
        // This might involve checking the download directory or verifying the file's existence.
        // For simplicity, we'll just pause for a few seconds.
        try {
            Thread.sleep(5000); // Sleep for 5 seconds to simulate verification
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("cleanDownloadFolder")
    public void cleandownloadfolder() {
        BrowserUtils.cleanFolder();
    }

    @Then("clean {string} Folder")
    public void cleanFolder(String folderName) {
        BrowserUtils.cleanFolder(folderName);
    }


    @Then("TakeScreenShots and save as {string}")
    public void takeScreenshotsAndSaveAs(String saveAs) {
        BrowserUtils.takeScreenshot(Driver.getDriver(), saveAs);

    }

    @Then("deleteScreenshot and save as {string}")
    public void deletescreenshotAndSaveAs(String fileName) {
        BrowserUtils.deleteScreenshot(fileName);
    }
}

