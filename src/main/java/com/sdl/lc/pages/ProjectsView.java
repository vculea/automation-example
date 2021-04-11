package com.sdl.lc.pages;

import static helpers.MappingsHelper.dropdownFieldsXpathHelper;

public class ProjectsView {
    private final String projects = "//a[contains(@class, 'x-btn') and count(*//text()[.='Projects']) > 0]";
    private final String newProject = "//a[contains(@class, 'x-btn') and count(*//text()[.='New Project']) > 0]";
    private final String projectName = "//input[@name='name']";
    private final String projectLocation = "//input[@name='location' and contains(@class, 'x-form-required-field')]";
    private final String projectSourceLanguage= dropdownFieldsXpathHelper("Source Language");
    private final String projectTargetLanguages= dropdownFieldsXpathHelper("Target Languages");
    private final String fileTypeConfiguration = dropdownFieldsXpathHelper("File Type Configuration");
    private final String fileTypeConfigurationValue = "//*[contains(text(), 'Default File Type Configuration') and not(contains(text(), 'HP folder'))]";
    private final String browseInput = "//*[text()='Drag your files or ']//parent::*//parent::*//parent::div//input[@data-ref='fileInputEl']";
    private final String nextButton = "//*[text() = 'Next']";
    private final String createAndStartButton = "//*[text() = 'Create & Start']";
    private final String translationEngine = "//*[@name = 'translationProfileId']";
    private final String pricingModel = "//*[@name = 'pricingModelId']";
    private final String workflow = "//*[@name = 'workflowId']";
    private final String searchProjectsField = "//input[contains(@name, 'remotesearchfield')]";

    public String getProjects() {
        return projects;
    }

    public String getNewProject() {
        return newProject;
    }

    public String getProjectName() { return projectName; }

    public String getProjectLocation() { return projectLocation; }

    public String getProjectSourceLanguage() { return projectSourceLanguage; }

    public String getProjectTargetLanguages() { return projectTargetLanguages; }

    public String getFileTypeConfiguration() {return fileTypeConfiguration; }

    public String getBrowseInput() {return browseInput; }

    public String getNextButton() {return nextButton; }

    public String getTranslationEngine() {return translationEngine; }

    public String getPricingModel() {return pricingModel; }

    public String getWorkflow() {return workflow; }

    public String getCreateAndStartButton() {return createAndStartButton; }

    public String getSearchProjectsField() {return searchProjectsField; }

    public String getFileTypeConfigurationValue() { return fileTypeConfigurationValue; }

}