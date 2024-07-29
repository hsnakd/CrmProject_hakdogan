package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class PdfDownloadSteps {
    private final String downloadDir = System.getProperty("user.dir") + "/src/test/resources/download";
    private final String pdfUrl = "https://www.hakdogan.com/doc/HASAN_AKDOGAN_RESUME.pdf";
    private final String pdfFileName = "HASAN_AKDOGAN_RESUME.pdf";

    @Given("I navigate to the PDF file")
    public void i_navigate_to_the_pdf_file() {
        Driver.getDriver().navigate().to(pdfUrl);
    }

    @When("I download the PDF file")
    public void i_download_the_pdf_file() {
        // Create download directory if it doesn't exist
        File downloadFolder = new File(downloadDir);
        if (!downloadFolder.exists()) {
            downloadFolder.mkdirs();
        }

        try {
            // Download the PDF file using HTTP request
            URL url = new URL(pdfUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(new File(downloadDir, pdfFileName))) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the PDF file should be downloaded")
    public void the_pdf_file_should_be_downloaded() {
        File file = new File(downloadDir, pdfFileName);
        assertTrue(file.exists());
    }

}
