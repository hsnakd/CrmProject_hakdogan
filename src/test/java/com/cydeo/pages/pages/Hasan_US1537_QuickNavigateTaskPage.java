package com.cydeo.pages.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Hasan_US1537_QuickNavigateTaskPage {

    public Hasan_US1537_QuickNavigateTaskPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Task']")
    public WebElement taskLink;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement messageTitle;

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement highPriority;

    @FindBy(xpath = "//body[@style='min-height: 84px;']")
    public WebElement messageBox;

    @FindBy(xpath = "//a[@class='js-id-tdp-mem-sel-is-open-form task-form-field-when-filled task-form-field-link add']")
    public WebElement addMoreButton;

    @FindBy(xpath = "(//a[contains(text(),'Add more')])[1]")
    public WebElement addMoreButton2;

    @FindBy(xpath = "(//div[text()='helpdesk100@cybertekschool.com'])[2]")
    public WebElement addPeople;

    @FindBy(xpath = "(//*[contains(@id, 'anchor_responsible')])[1]")
    public WebElement addPeopleCheck;

    @FindBy(xpath = "(//div[text()='marketing98@cybertekschool.com'])[2]")
    public WebElement addSecondPeople;

    @FindBy(xpath = "//*[normalize-space()='marketing98@cybertekschool.com']")
    public WebElement addSecondPeopleCheck;


    @FindBy(xpath = "//*[contains(@id, 'destDepartmentTab')]")
    public WebElement employeesAndDepartments;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButtonID;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//a[@title='Tasks']")
    public WebElement taskLeftSide;

    @FindBy(id = "task-detail-important-button")
    public WebElement highPriorityCheck;

    @FindBy(xpath = "//div[@data-priority='2']")
    public WebElement highPriorityCheck1;

    @FindBy(xpath = "//div[@data-priority='2']")
    public WebElement highPriorityCheck2;

    @FindBy(xpath = "//a[@class='task-title task-status-text-color-accepted']")
    public WebElement taskName;

    @FindBy(xpath = "//span[@data-target='checklist']")
    public WebElement checkList;

    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement checklistThingsToDo;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-open-form task-dashed-link-inner']")
    public WebElement checklistAdd;

    @FindBy(xpath = "//a[.='US-1537_TC-01']")
    public WebElement checklistTask;

    @FindBy(xpath = "//*[contains(@class, 'js-id-checklist-is-i-titl')]")
    public WebElement checkChecklistAdded;

    @FindBy(xpath = "//iframe[contains(@id, 'iframe')]")
    public WebElement checklistVerifyIframe;

    @FindBy(xpath = "//input[@data-bx-id='datepicker-display'] [@class='task-options-inp']")
    public WebElement deadlineAdd;

    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement deadlineYear;

    @FindBy(xpath = "//span[@data-bx-year='2023']")
    public WebElement selectYear;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement deadlineMonth;

    @FindBy(xpath = "//span[@data-bx-month='4']")
    public WebElement selectMonth;

    @FindBy(xpath = "(//*[contains(@class, 'bx-calendar-cell')])[.='3']")
//    @FindBy(xpath = "//a[@class='bx-calendar-cell'] [.='3']")
    public WebElement selectDay;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[1]")
    public WebElement selectHour;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[2]")
    public WebElement selectMinute;

    @FindBy(xpath = "//span[@class='bx-calendar-button-text']")
    public WebElement selectButton;

    @FindBy(xpath = "//a[.='US-1537_TC-01']")
    public WebElement deadlineTask;

    @FindBy(xpath = "//*[@id='task-detail-deadline']")
    public WebElement checkDeadline;

    @FindBy(xpath = "//span[.='Time planning']")
    public WebElement timePlanning;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-start-date-plan']")
    public WebElement startTime;

    @FindBy(xpath = "//input[@data-bx-id='dateplanmanager-duration']")
    public WebElement durationTime;

    @FindBy(xpath = "//span[@data-unit='days']")
    public WebElement durationDay;

    @FindBy(xpath = "//span[@data-unit='hours']")
    public WebElement durationHours;

    @FindBy(xpath = "//span[@data-unit='mins']")
    public WebElement durationMins;

    @FindBy(xpath = "//a[.='US-1537_TC-01']")
    public WebElement timePlanningTask;

    @FindBy(xpath = "//*[text()='05/03/2023 09:00 am']")
    public WebElement checkStartTimePlanningAdded;

    @FindBy(xpath = "//span[@class='menu-item-link-text']")
    public WebElement activityStream;

    @FindBy(xpath = "//table[@class='main-grid-panel-table']//tr/td[2]//span[2]")
    public WebElement count;

    @FindBy(tagName = "frame")
    public WebElement iframe;

}
