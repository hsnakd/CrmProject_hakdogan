package com.cydeo.pages.pages;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchElementInFrames {

    public static void main(String[] args) {

        // Navigate to your web page
        Driver.getDriver().get("https://example.com");

        // Example locator (replace with your actual locator)
        By elementLocator = By.xpath("//*[normalize-space()='Your element text']");

        // Call searchElementInFrames from BrowserUtil to find the element
        WebElement foundElement = BrowserUtils.searchElementInFrames(Driver.getDriver(), elementLocator);

        // Check if an element is found
        if (foundElement != null) {
            // Element found, you can perform further actions
            System.out.println("Element found: " + foundElement.getText());
        } else {
            // Element not found
            System.out.println("Element not found in any iframe.");
        }

    }
}
