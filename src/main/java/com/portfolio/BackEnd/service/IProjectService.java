package com.portfolio.BackEnd.service;


import com.portfolio.BackEnd.model.Project;

import java.util.List;

public interface IProjectService {

    List<Project> getProject();

    void updateProject(Project proj);

    void deleteProject(Long id);

    Project findProject(Long id);

}
