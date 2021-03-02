package com.sdl.lc.project.steps;

import com.sdl.lc.pages.ProjectsView;
import com.sdl.lc.project.TestBase;
import com.sdl.selenium.web.utils.Utils;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

public class ProjectSteps extends TestBase {
    ProjectsView projectsView = new ProjectsView();

    @And("I open Projects page")
    public void iOpenProjectsPage() {
        driver.findElement(By.xpath(projectsView.getProjects())).click();
    }

    @And("I click on 'New Project' button")
    public void iClickOnNewProjectButton() {
        Utils.sleep(1000); // This sleep is not ok, you have another better idea?
        driver.findElement(By.xpath(projectsView.getNewProject())).click();
    }
}
