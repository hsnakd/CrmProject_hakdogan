package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sukru_US1530_File_UploadPage {
    public Sukru_US1530_File_UploadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Message']")
    public WebElement message;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement upload;

    @FindBy(xpath = "//span[. = 'Select document from Bitrix24']")
    public WebElement selectFromBitrix;

    @FindBy(xpath = "//*[@id=\"bx-file-dialog-content-DiskFileDialog\"]/div/div[3]/div[1]/span[1]/a")
    public WebElement firstPicture;

    @FindBy(xpath = "//a[. = 'Test_Case_Writing_Tips (26).pdf']")
    public WebElement secondFile;

    @FindBy(xpath = "//a[. = 'sprint2 (33).png']")
    public WebElement thirdFile;

    @FindBy(xpath = "//span[.='Select document']")
    public WebElement selectButton;

    @FindBy(xpath = "//span[.='Insert in text']")
    public  WebElement insertInText;


    @FindBy(xpath = "//a[.='sprint2 (31).png']")
    public WebElement picture1onBitrix;
    @FindBy(xpath = "//a[.='sprint2 (30).png']")
    public WebElement picture2onBitrix;
    @FindBy(xpath = "//a[.='sprint2 (33).png']")
    public WebElement picture3onBitrix;



    @FindBy(xpath = "(//span[@class='f-wrap'])[1]")
    public WebElement picture1AttachedFiles;

    @FindBy(xpath ="(//span[@class='f-wrap'])[2]" )
    public WebElement picture2AttachedFiles;

    @FindBy(xpath = "(//span[@class='f-wrap'])[3]")
    public WebElement picture3AttachedFiles;

    @FindBy(xpath = "(//iframe[1])[1]")
    public  WebElement iframe;

    @FindBy(xpath = "(//body[@contenteditable='true']/img)[1]")
    public WebElement picture1onIframe;

    @FindBy(xpath = "(//body[@contenteditable='true']/img)[2]")
    public WebElement picture2onIframe;

    @FindBy(xpath = "(//body[@contenteditable='true']/img)[3]")
    public WebElement picture3onIframe;

    @FindBy(xpath = "//*[@id=\"blog-submit-button-save\"]")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"disk-attach-image-371\"]")
    public WebElement picture1OnActivityStream;

    @FindBy(xpath = "//*[@id=\"disk-attach-image-372\"]")
    public WebElement picture2OnActivityStream;

    @FindBy(xpath = "//*[@id=\"disk-attach-image-373\"]")
    public WebElement picture3OnActivityStream;

    @FindBy(xpath = "//*[@id=\"diskuf-edit-rigths-doc\"]")
    public WebElement allowRecipientToEditCheckbox;

    @FindBy(xpath = "//*[@id=\"disk-edit-attachn3250\"]/td[5]/span")
    public WebElement deleteAttachedFileButton;

    @FindBy(xpath = "(//span[.='Drag files here to upload'])[2]")
    public WebElement uploadFilesAndImagesButton;

    @FindBy(css = "#disk-edit-attachn2326 > td.files-name > span.files-text > span.files-name-edit-btn")
    public WebElement nameEditButton;


}
