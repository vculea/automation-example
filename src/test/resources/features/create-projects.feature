@screen
@logs
Feature: Create project

  Scenario: Login
    Given I open url "https://uat-languagecloud.sdl.com/lc/login"
    When I login with "admin.test.uat@sdl.testinator.com" and "Weaver123"

  Scenario: Create project
    And I open Projects page
    And I click on 'New Project' button
    And I stop the test
    And I type in the Name field a random string
    And I fill in the Location "HP"
    And I fill in the Source Language "English (United States)"
    And I fill in the Target Languages "Urdu (India)"
    And I fill in the File Type Configuration
    And I upload the following File: "test.txt"
    And I click the next button
    And I fill in the Translation Engine "HP_TranslationEngine"
    And I click the next button
    And I fill in the Pricing Model "pricing_model_HP"
    And I click the next button
    And I fill in the Workflow "WF-4_CP_2Languages"
    And I click the create and start button
    Then The project with random name was created correctly

  Scenario: Logout
    And I logout from LC