package com.cydeo.utilities;

import com.cydeo.pages.CrmProjectTask_Page;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
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
     * Downloads a file from a given URL and saves it to the specified local path.
     *
     * @param fileURL     The URL of the file to download.
     * @param localPath   The local file path where the downloaded file should be saved.
     */

    public static void downloadFile(String fileURL, String localPath) {
        WebDriver driver = Driver.getDriver();

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Use contextClick method to perform right-click action
        actions.contextClick(driver.findElement(By.linkText(fileURL))).build().perform();

        // Press the 'v' key on the keyboard to open the "Save Link As" dialog on Mac
        actions.sendKeys("v").build().perform();

        // Wait for the "Save As" dialog to appear
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Save As")));

        // Set the file name and location in the dialog and press Enter
        WebElement fileNameInput = Driver.getDriver().findElement(By.name("Save As"));
        fileNameInput.clear();
        fileNameInput.sendKeys(localPath);
        actions.sendKeys("\n").build().perform();
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





}


