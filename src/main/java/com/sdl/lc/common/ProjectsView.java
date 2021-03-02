package com.sdl.lc.common;

public class ProjectsView {
    private final String projects = "//a[contains(@class, 'x-btn') and count(*//text()[.='Projects']) > 0]";
    private final String newProject = "//a[contains(@class, 'x-btn') and count(*//text()[.='New Project']) > 0]";

    public String getProjects() {
        return projects;
    }

    public String getNewProject() {
        return newProject;
    }
}
