package com.sdl.lc.project.steps;

import com.sdl.lc.pages.ProjectsView;
import com.sdl.lc.project.TestBase;
import file.FileHelper;
import helpers.MappingsHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static helpers.ActionsHelper.selectValueDropdownAndWait;
import static helpers.ActionsHelper.waitForNotificationMessage;

public class ProjectSteps extends TestBase {
    ProjectsView projectsView = new ProjectsView();
    public static String projectName = RandomStringUtils.randomAlphabetic(10);

    @And("I open Projects page")
    public void iOpenProjectsPage() {
        driver.findElement(By.xpath(projectsView.getProjects())).click();
    }

    @And("I click on 'New Project' button")
    public void iClickOnNewProjectButton() {
        driver.findElement(By.xpath(projectsView.getNewProject())).click();
    }

    @And("I type in the Name field a random string")
    public void iTypeInTheNameField(){
        driver.findElement(By.xpath(projectsView.getProjectName())).sendKeys(projectName);
    }

    @And("I fill in the Location {string}")
    public void iFillInTheLocation(String location){
        driver.findElement(By.xpath(projectsView.getProjectLocation())).sendKeys(location);
    }

    @And("I fill in the Source Language {string}")
    public void iFillInTheSourceLanguage(String sourceLanguage){
        driver.findElement(By.xpath(projectsView.getProjectSourceLanguage())).sendKeys(sourceLanguage);
    }

    @And("I fill in the Target Languages {string}")
    public void iFillInTheTargetLanguage(String targetLanguages){
        driver.findElement(By.xpath(projectsView.getProjectTargetLanguages())).sendKeys(targetLanguages);
    }

    @And("I fill in the File Type Configuration")
    public void iFillInTheFileTypeConfiguration(){
        WebElement webElement = driver.findElement(By.xpath(projectsView.getFileTypeConfiguration()));
        webElement.click();
        webElement.sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath(projectsView.getFileTypeConfigurationValue())).click();
    }

    @And("I upload the following File: {string}")
    public void iUploadTheFollowingFile(String filename){
        driver.findElement(By.xpath(projectsView.getBrowseInput())).sendKeys(FileHelper.getFilePath(filename));
    }

    @And("I click the next button")
    public void iClickTheNextButton(){
        driver.findElement(By.xpath(projectsView.getNextButton())).click();
    }

    @And("I fill in the Translation Engine {string}")
    public void iFillInTheTranslationEngine(String translationEngine){
        selectValueDropdownAndWait(driver, projectsView.getTranslationEngine(), translationEngine, "Termbases");
    }

    @And("I fill in the Pricing Model {string}")
    public void iFillInThePricingModel(String pricingModel){
        selectValueDropdownAndWait(driver, projectsView.getPricingModel(), pricingModel, "Additional language costs");
    }

    @And("I fill in the Workflow {string}")
    public void iFillInTheWorkflow(String workflow){
        selectValueDropdownAndWait(driver, projectsView.getWorkflow(), workflow, "Preprocessing");
    }

    @And("I click the create and start button")
    public void iClickTheCreateAndStartButton(){
        driver.findElement(By.xpath(projectsView.getCreateAndStartButton())).click();
        waitForNotificationMessage(driver, projectName);
    }

    @Then("The project with random name was created correctly")
    public void theCreatedProjectAppearsInTheList(){
        driver.findElement(By.xpath(projectsView.getSearchProjectsField())).sendKeys(projectName);
        Assert.assertTrue(driver.findElement(By.xpath(MappingsHelper.getProjectInTable(projectName))).isDisplayed());
    }

}
