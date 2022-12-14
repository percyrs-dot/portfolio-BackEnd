package com.portfolio.BackEnd.controller;


import com.portfolio.BackEnd.model.Project;
import com.portfolio.BackEnd.repository.ProjectRepository;
import com.portfolio.BackEnd.service.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    private final IProjectService projServ;
    private final ProjectRepository projRepo;

    public ProjectController(IProjectService projServ, ProjectRepository projRepo) {
        this.projServ = projServ;
        this.projRepo = projRepo;
    }

    @PostMapping("/proj/post")
    public void updateProject(@RequestBody Project proj) {
        projServ.updateProject(proj);
    }

    @GetMapping("/proj/get")
    @ResponseBody
    public List<Project> getProject() {
        return projServ.getProject();
    }

    @PutMapping ("/proj/put/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody Project Project) {
        Optional<Project> optionalProject = Optional.ofNullable(projServ.findProject(Long.valueOf(id)));
        if (optionalProject.isPresent()) {
            Project proj = optionalProject.get();
            if (!Project.getName().isEmpty())
                proj.setName(Project.getName());
            if (!Project.getDescription().isEmpty())
                proj.setDescription(Project.getDescription());
            if (Project.getYear() != null)
                proj.setYear(Project.getYear());
            if (!Project.getImg().isEmpty())
                proj.setImg(Project.getImg());
            if (!Project.getUrl().isEmpty())
                proj.setUrl(Project.getUrl());
            return new ResponseEntity<>(projRepo.save(proj), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/proj/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projServ.deleteProject(id);
    }

    @GetMapping("/proj/get/{id}")
    @ResponseBody
    public Project findProject(@PathVariable Long id) {
        return projServ.findProject(id);
    }
}
