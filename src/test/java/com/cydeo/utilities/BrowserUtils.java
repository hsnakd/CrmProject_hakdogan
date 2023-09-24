package com.cydeo.utilities;

import com.cydeo.pages.CrmProjectTask_Page;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.util.*;

public class BrowserUtils {

    /*
This method will accept int (in seconds) and execute Thread.sleep
for given duration
 */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    /**
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /**
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }


    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String.
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString= new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return  actualOptionsAsString;

    }


    /**
     * This method will accept a group radio buttons as a List of WebElement.
     * It will loop through the List, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of elements
     *
     * @param webElementList of webelements
     * @return list of string
     *
     *         This method accepts a List<WebElements> and returns List<String>
     */
    public static List<String> getElementsText(List<WebElement> webElementList){

        //Create placeholder List<String>
        List<String> actualAsString = new ArrayList<>();

        for (WebElement each : webElementList) {
            actualAsString.add(each.getText());
        }

        return actualAsString;

    }

    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /*
    This method accepts WebElement target,
    and waits for that WebElement not to be displayed on the page
     */
    public static void waitForInvisibilityOf(WebElement target, int timeout){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }


    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title, int timeout){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }


    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }


    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1) {
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlights an element by changing its background and border color
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * attempts to click on provided element until given time runs out
     *
     * @param element
     * @param timeout
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }


    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param by
     * @param attempts
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJS(Driver.getDriver().findElement(by));
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }

    /**
     *  checks that an element is present on the DOM of a page. This does not
     *    * necessarily mean that the element is visible.
     * @param by
     * @param time
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

/**

*/

    public static void iframe1() {
        int size = Driver.getDriver().findElements(By.tagName("iframe")).size();

        for(int i=0; i<=size; i++){
            Driver.getDriver().switchTo().frame(i);
            int total=Driver.getDriver().findElements(By.xpath("html/body/a/img")).size();
            System.out.println(total);
            Driver.getDriver().switchTo().defaultContent();
        }
    }

    public static int iframe(By element) {
        CrmProjectTask_Page taskPage = new CrmProjectTask_Page();

        int size =  Driver.getDriver().findElements(By.tagName("iframe")).size();
        System.out.println("size = " + size);
        int i=0;
        int frameNumber=0;

        try {
            for( i=0; i<size; i++){
                Driver.getDriver().switchTo().frame(i);
                if ( (taskPage.addPeopleCheck.isDisplayed()) ) {
                    System.out.println("iframe number : "  + " " + i);
                    frameNumber=i;
                }

                Driver.getDriver().switchTo().defaultContent();
            }
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ignored) {
        return frameNumber;
        }

        return i;

    }

    public static int switchToIFrameWithElement(WebElement element) {

        Driver.getDriver().switchTo().defaultContent();
        int size = Driver.getDriver().findElements(By.tagName("iframe")).size();
        System.out.println("size = " + size);
        int frameNumber=0;
        try {
            if (element.isDisplayed()) {
//                System.out.println("Element is displayed on main page");
            }
        } catch (Exception continueFlow) {
//            List<WebElement> frames = Driver.getDriver().findElements(By.cssSelector("iframe"));

            for ( int i=0; i<size; i++) {
                Driver.getDriver().switchTo().defaultContent();
//                System.out.println("going back to main page" + frameNumber );
                frameNumber=i;
                try {
                    Driver.getDriver().switchTo().frame(i);
//                    System.out.println("switched to next frame: " + frameNumber);
                    if (element.isDisplayed()) {
                        frameNumber=i;
//                        System.out.println("element is found in frame: " + frameNumber);
                        break;
                    }
                } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ignored) {
                }
            }
        }
//        System.out.println("returned element successfully");
        return frameNumber;
    }



    /**
     * Accepts a JavaScript alert.
     */
    public static void acceptAlert() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    /**
     * Dismisses a JavaScript alert.
     */
    public static void dismissAlert() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();
    }

    /**
     * Sends text to a JavaScript alert.
     *
     * @param text Text to send to the alert.
     */
    public static void sendTextToAlert(String text) {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(text);
    }

    // Get the text from an alert
    public static String getAlertText() {
        Alert alert = Driver.getDriver().switchTo().alert();
        return alert.getText();
    }


    /**
     * Capture a screenshot of the current browser window.
     *
     * @param filePath The file path to save the screenshot.
     */
    public static void captureScreenshot(String filePath) {
        WebDriver driver = Driver.getDriver();
        if (driver instanceof TakesScreenshot) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Scroll down the page by a specified number of pixels.
     *
     * @param pixels Number of pixels to scroll down.
     */
    public static void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, " + pixels + ")");
    }

    /**
     * Simulate pressing a key on the keyboard.
     *
     * @param key The key to press (e.g., Keys.ENTER, Keys.TAB).
     */
    public static void pressKey(Keys key) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(key).perform();
    }

    /**
     * Navigate forward in the browser's history.
     */
    public static void navigateForward() {
        Driver.getDriver().navigate().forward();
    }

    /**
     * Navigate backward in the browser's history.
     */
    public static void navigateBackward() {
        Driver.getDriver().navigate().back();
    }

    /**
     * Navigate to a specific URL.
     *
     * @param url The URL to navigate to.
     */
    public static void navigateToURL(String url) {
        Driver.getDriver().navigate().to(url);
    }

    /**
     * Add a new browser cookie.
     *
     * @param name  The name of the cookie.
     * @param value The value of the cookie.
     */
    public static void addCookie(String name, String value) {
        Cookie cookie = new Cookie.Builder(name, value)
                .domain("example.com") // Specify the domain
                .build();
        Driver.getDriver().manage().addCookie(cookie);
    }

    /**
     * Delete a browser cookie by name.
     *
     * @param name The name of the cookie to delete.
     */
    public static void deleteCookie(String name) {
        Driver.getDriver().manage().deleteCookieNamed(name);
    }

    /**
     * Get all window handles and switch to a specific window by its title.
     *
     * @param windowTitle The title of the window to switch to.
     */
    public static void switchToWindowByTitle(String windowTitle) {
        WebDriver driver = Driver.getDriver();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    }


    /**
     * Uploads a file to an input element using its local file path.
     *
     * @param fileInput   The WebElement representing the file input field.
     * @param filePath    The local file path of the file to upload.
     */

    public static void uploadFile(WebElement fileInput, String filePath) {
        WebDriver driver = Driver.getDriver();
        ((RemoteWebElement) fileInput).setFileDetector(new LocalFileDetector());
        fileInput.sendKeys(filePath);
    }



    /**
     * Add a new browser cookie.
     *
     * @param name  The name of the cookie.
     * @param value The value of the cookie.
     * @param domain The domain of the cookie.
     */
    public static void addCookie(String name, String value, String domain) {
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domain)
                .build();
        Driver.getDriver().manage().addCookie(cookie);
    }


    /**
     * Open a new browser tab with a specific URL.
     *
     * @param url The URL to open in the new tab.
     */
    public static void openNewTab(String url) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('" + url + "','_blank');");
    }

    /**
     * Perform a drag-and-drop action from the source element to the target element.
     *
     * @param sourceElement The source element to drag.
     * @param targetElement The target element to drop onto.
     */
    public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }


    /**
     * Switch to a specific iframe by index.
     *
     * @param index The index of the iframe to switch to.
     */
    public static void switchToIFrame(int index) {
        Driver.getDriver().switchTo().frame(index);
    }

    // Switch to a frame by its WebElement
    public static void switchToIFrame(WebElement frameElement) {
        Driver.getDriver().switchTo().frame(frameElement);
    }


    /**
     * Switch back to the main content from an iframe.
     */
    public static void switchToMainContent() {
        Driver.getDriver().switchTo().defaultContent();
    }

    // Highlight an element by changing its border color
    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }


    // Switch to a specific window or tab by its handle
    public static void switchToWindowByHandle(String windowHandle) {
        Driver.getDriver().switchTo().window(windowHandle);
    }

    // Open a new tab and switch to it
    public static void openNewTab() {
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    // Close the current tab or window
    public static void closeCurrentTab() {
        Driver.getDriver().close();
    }



    /**
     This method accepts String expected title
     @param expectedTitle
     */
    public static void assertTitle(String expectedTitle){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }



    public static WebElement fluentWait(final By locator, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeInSec));
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }


    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     *
     * @param select
     * @return
     */
    public WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }


    /***
     * This method takes screenshots
     */
    private static final String screenshotDir = "src/test/resources/Files/ScreenShots/";

    public static void takeScreenshot(WebDriver driver, String saveAs) {
        try {
            // Get the current date and time for a unique file name
            String dateTime = LocalDate.now() + "_" + LocalTime.now().toString().substring(0, 5);
            saveAs = saveAs + "_" + dateTime.replaceAll("[-,:]", "");

            // Cast the WebDriver to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Capture the screenshot as a File
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination directory
//            String screenshotDir = "src/test/resources/Files/ScreenShots/";

            // Create the directory if it doesn't exist
            File directory = new File(screenshotDir);  // line 882
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Define the complete path for saving the screenshot
            String screenshotPath = screenshotDir + saveAs + ".png";

            // Copy the screenshot file to the specified path
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));

            // Print the path to the console or log for reference
            System.out.println("Screenshot saved as: " + screenshotPath);
        } catch (IOException e) {
            // Handle any exceptions that occur during the screenshot capture or file operations
            e.printStackTrace();
        }
    }




    // Your other utility methods here...

    /**
     * Deletes a screenshot file in the specified screenshot directory.
     *
     * @param fileName The name of the screenshot file to delete (excluding the directory path).
     */
    public static void deleteScreenshot(String fileName) {
//        Define the destination directory
//        String screenshotDir = "src/test/resources/Files/ScreenShots/";
        String filePath = screenshotDir + fileName;
        File screenshotFile = new File(filePath);

        if (screenshotFile.exists() && screenshotFile.isFile()) {
            screenshotFile.delete();
        }

    }


    /**
     * Reads data from an Excel file at a specified row and cell.
     *
     * @param filePath The path to the Excel file.
     * @param sheetName The name of the sheet in the Excel file.
     * @param rowNum The row number (0-based index) to read data from.
     * @param cellNum The cell number (0-based index) to read data from.
     * @return The data read from the specified cell.
     */

    private static final String excelFileDir = "src/test/resources/Files/excelFile/";

//    public static String readExcelData(String filePath, String sheetName, int rowNum, int cellNum) {
    public static String readExcelData(String sheetName, int rowNum, int cellNum) {
        String cellValue = null;
        FileInputStream file = null;
        XSSFWorkbook workbook = null;

        try {
            file = new FileInputStream(excelFileDir);
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            cellValue = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return cellValue;
    }

    /**
     * Writes data to an Excel file at a specified row and cell.
     *
     * @param filePath The path to the Excel file.
     * @param sheetName The name of the sheet in the Excel file.
     * @param rowNum The row number (0-based index) to write data to.
     * @param cellNum The cell number (0-based index) to write data to.
     * @param data The data to write to the specified cell.
     */
    public static void writeExcelData(String filePath, String sheetName, int rowNum, int cellNum, String data) {
        FileInputStream file = null;
        XSSFWorkbook workbook = null;
        FileOutputStream outFile = null;

        try {
            file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            Cell cell = row.createCell(cellNum);
            cell.setCellValue(data);

            outFile = new FileOutputStream(filePath);
            workbook.write(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (file != null) {
                    file.close();
                }
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





    // Method to create a folder
    public static void createFolder() {
        String folderPath = "src/test/java/com/cydeo/Download";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            boolean folderCreated = folder.mkdirs();
            if (folderCreated) {
                System.out.println("Download folder created at: " + folder.getAbsolutePath());
            } else {
                System.err.println("Failed to create download folder.");
            }
        } else {
            System.out.println("Download folder already exists at: " + folder.getAbsolutePath());
        }
    }



    // Method to create a folder
    public static void createFolder(String folderName) {
        String folderPath = "src/test/java/com/cydeo/" + folderName;
        File folder = new File(folderPath);

        if (!folder.exists()) {
            boolean folderCreated = folder.mkdirs();
            if (folderCreated) {
                System.out.println(folderName + " folder created at: " + folder.getAbsolutePath());
            } else {
                System.err.println("Failed to create " + folderName + " folder.");
            }
        } else {
            System.out.println(folderName + " folder already exists at: " + folder.getAbsolutePath());
        }
    }



    // Method to delete a folder
    public static void deleteFolder() {
        String folderPath = "src/test/java/com/cydeo/Download";
        File folder = new File(folderPath);

        if (folder.exists()) {
            boolean folderDeleted = delete_Folder(folder);
            if (folderDeleted) {
                System.out.println("Download folder deleted.");
            } else {
                System.err.println("Failed to delete download folder.");
            }
        } else {
            System.out.println("Download folder does not exist.");
        }
    }



    // Method to delete a folder
    public static void deleteFolder(String folderName) {
        String folderPath = "src/test/java/com/cydeo/" + folderName;
        File folder = new File(folderPath);

        if (folder.exists()) {
            boolean folderDeleted = delete_Folder(folder);
            if (folderDeleted) {
                System.out.println(folderName + " folder deleted.");
            } else {
                System.err.println("Failed to delete " + folderName + " folder.");
            }
        } else {
            System.out.println(folderName + " folder does not exist.");
        }
    }


    // Recursive method to delete a folder and its contents
    private static boolean delete_Folder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFolder(String.valueOf(file));
                    } else {
                        if (!file.delete()) {
                            System.err.println("Failed to delete file: " + file.getAbsolutePath());
                            return false;
                        }
                    }
                }
            }
        }
        return folder.delete();
    }



    public static void cleanFolder(){
        File folder = new File(System.getProperty("user.dir") + "/src/test/java/com/cydeo/Download");
        File[] files = folder.listFiles();
        for (File file : files) {
            file.delete();
        }
    }


    public static void cleanFolder(String folderName){
        File folder = new File(System.getProperty("user.dir") + "/src/test/java/com/cydeo/" + folderName);
        File[] files = folder.listFiles();
        for (File file : files) {
            file.delete();
        }
    }



    // Method to count the number of files in a folder
    public static int countFilesInFolder() {
        String folderPath = "src/test/java/com/cydeo/Download";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                int numberOfFiles =  files.length;
                System.out.println("Number of files in the download folder: " + numberOfFiles);
                return numberOfFiles;
            }
        }
        // If the folder doesn't exist or is empty, return 0
        return 0;
    }



    // Method to count the number of files in a folder
    public static int countFilesInFolder(String folderName) {
        String folderPath = "src/test/java/com/cydeo/" + folderName;
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                int numberOfFiles =  files.length;
                System.out.println("Number of files in the " + folderName + " folder: " + numberOfFiles);
                return numberOfFiles;
            }
        }
        // If the folder doesn't exist or is empty, return 0
        return 0;
    }


//    private WebDriver driver;
//
//    // Constructor
//    public BrowserUtils(WebDriver driver) {
//        this.driver = driver;
//    }

    // Method to download a file
    public static void downloadFile(String fileUrl) {
        // Navigate to the file URL
        Driver.getDriver().get(fileUrl);

        // Find the link to download the file
        WebElement downloadLink = Driver.getDriver().findElement(By.linkText("Download"));

        // Get the file download URL
        String fileDownloadUrl = downloadLink.getAttribute("href");

        // Use a tool like wget or curl to download the file
        // You can use Java's ProcessBuilder to execute shell commands
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("wget", "-P", "/path/to/save/directory", fileDownloadUrl);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("File downloaded successfully.");
            } else {
                System.err.println("Failed to download the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}


