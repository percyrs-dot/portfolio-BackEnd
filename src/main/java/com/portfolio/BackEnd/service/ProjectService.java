package com.portfolio.BackEnd.service;


import com.portfolio.BackEnd.model.Project;
import com.portfolio.BackEnd.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    private final ProjectRepository projRepo;

    public ProjectService(ProjectRepository projRepo) {
        this.projRepo = projRepo;
    }

    @Override
    public List<Project> getProject() {
        return projRepo.findAll();
    }

    @Override
    public void updateProject(Project proj) {
        projRepo.save(proj);
    }

    @Override
    public void deleteProject(Long id) {
        projRepo.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        return projRepo.findById(id).orElse(null);
    }

}