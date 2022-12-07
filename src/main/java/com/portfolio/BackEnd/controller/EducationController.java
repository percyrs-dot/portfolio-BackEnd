package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Education;
import com.portfolio.BackEnd.service.IEducationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EducationController {

    private final IEducationService eduServ;

    public EducationController(IEducationService eduServ) {
        this.eduServ = eduServ;
    }

    @PostMapping("/edu/post")
    public void updateEducation(@RequestBody Education edu) {
        eduServ.updateEducation(edu);
    }

    @GetMapping("/edu/get")
    @ResponseBody
    public List<Education> getEducation() {
        return eduServ.getEducation();
    }

    @DeleteMapping("/edu/delete/{id}")
    public void deleteEducation(@PathVariable Long id) {
        eduServ.deleteEducation(id);
    }

    @GetMapping("/edu/get/{id}")
    @ResponseBody
    public Optional<Education> findEducation(@PathVariable Long id) {
        return eduServ.findEducation(id);
    }
}
