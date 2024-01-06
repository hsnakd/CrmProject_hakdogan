@Selenium4 @smoke
Feature: Selenium4
  User Story :
  As a user, I should be able to use Selenium4.


  Background: log in page feature
    Given go to page
    When on the home gape


# 1. GetMethods
  @GetMethods
  Scenario: GetMethods
    Then GetMethods


# 2. WindowMinimize
  @WindowMinimize
  Scenario: WindowMinimize
    Then WindowMinimize


# 3. NewWindowNewTab
  @NewWindowNewTab
  Scenario: NewWindowNewTab
    Then NewWindowNewTab


# 4. RelativeLocators
  @RelativeLocators
  Scenario: RelativeLocators
    Then RelativeLocators


# 5. DurationOfSeconds
  @DurationOfSeconds
  Scenario: DurationOfSeconds
    Then DurationOfSeconds


## 5-1. createDownloadFolder
#  @createDownloadFolder
#  Scenario: createDownloadFolder
#    Then createDownloadFolder


# 5-2. createFolderName
  @createFolderName
  Scenario: createFolderName
    Then createFolder "HsnAkd"


## 6-1. countFilesInDownloadFolder
#  @countFilesInDownloadFolder
#  Scenario:   countFilesInDownloadFolder
#    Then countFilesInDownloadFolder


# 6-2. countFilesInFolderName
  @countFilesInFolderName
  Scenario: countFilesInFolderName
    Then countFilesIn "HsnAkd"


## 7-1. deleteDownloadFolder
#  @deleteDownloadFolder
#  Scenario: deleteDownloadFolder
#    Then deleteDownloadFolder



# 9-2. cleanFolderName
  @cleanFolderName
  Scenario: cleanFolderName
    Then clean "HsnAkd" Folder


# 7-2. deleteFolderName
  @deleteFolderName
  Scenario: deleteFolderName
    Then delete "HsnAkd"


# 8-1. createCountDeleteDownloadFolder
  @createCountDeleteDownloadFolder
  Scenario: createCountDeleteDownloadFolder
    Then createCountDeleteDownloadFolder


# 8-2. createCountDeleteFolderName
  @createCountDeleteFolderName
  Scenario: createCountDeleteFolderName
    Then createCountDelete "HsnAkd"



## 9-1. cleanDownloadFolder
#  @cleanDownloadFolder
#  Scenario: cleanDownloadFolder
#    Then cleanDownloadFolder




# 10. TakeScreenShots
  @TakeScreenShots
  Scenario: TakeScreenShots
    Then TakeScreenShots and save as "HsnAkd"


# 10. deleteScreenshot
  @deleteScreenshot
  Scenario: deleteScreenshot
    Then deleteScreenshot and save as "HsnAkd_20230924_1947.png"




#  Scenario: Download a PDF file from a website
#    Given I am on the website
#    When I click on the PDF download link
#    Then the PDF file should be downloaded successfully
