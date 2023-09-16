@Selenium4 @smoke
Feature: Quick Navigate Menu Task feature
  User Story :
  As a user, I should be able to assign tasks under Quick Navigate Menu.


  Background: log in page feature
    Given go to page
    When on the home gape


# 1. GetMethods
  @GetMethods
  Scenario:   GetMethods
    Then GetMethods


# 2. WindowMinimize
  @WindowMinimize
  Scenario:   WindowMinimize
    Then WindowMinimize


# 3. NewWindowNewTab
  @NewWindowNewTab
  Scenario:   NewWindowNewTab
    Then NewWindowNewTab


# 4. RelativeLocators
  @RelativeLocators
  Scenario:   RelativeLocators
    Then RelativeLocators


# 5. DurationOfSeconds
  @DurationOfSeconds
  Scenario:   DurationOfSeconds
    Then DurationOfSeconds


# 5-1. createDownloadFolder
  @createDownloadFolder
  Scenario:   createDownloadFolder
    Then createDownloadFolder


# 5-2. createFolderName
  @createFolderName
  Scenario:   createFolderName
    Then createFolder "HsnAkd"



# 6-1. countFilesInDownloadFolder
  @countFilesInDownloadFolder
  Scenario:   countFilesInDownloadFolder
    Then countFilesInDownloadFolder


# 6-2. countFilesInFolderName
  @countFilesInFolderName
  Scenario:   countFilesInFolderName
    Then countFilesIn "HsnAkd"


# 7-1. deleteDownloadFolder
  @deleteDownloadFolder
  Scenario:   deleteDownloadFolder
    Then deleteDownloadFolder


# 7-2. deleteFolderName
  @deleteFolderName
  Scenario:   deleteFolderName
    Then delete "HsnAkd"


# 8-1. createCountDeleteDownloadFolder
  @createCountDeleteDownloadFolder
  Scenario:   createCountDeleteDownloadFolder
    Then createCountDeleteDownloadFolder


# 8-2. createCountDeleteFolderName
  @createCountDeleteFolderName
  Scenario:   createCountDeleteFolderName
    Then createCountDelete "HsnAkd"

