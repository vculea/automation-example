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


  Scenario: Logout
    And I logout from LC
