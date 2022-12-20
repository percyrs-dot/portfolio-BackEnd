package com.portfolio.BackEnd.controller;


import com.portfolio.BackEnd.model.Education;
import com.portfolio.BackEnd.repository.EducationRepository;
import com.portfolio.BackEnd.service.IEducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EducationController {

    private final IEducationService eduServ;
    private final EducationRepository eduRepo;

    public EducationController(IEducationService eduServ, EducationRepository eduRepo) {
        this.eduServ = eduServ;
        this.eduRepo = eduRepo;
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

    @PutMapping ("/edu/put/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody Education education) {
        Optional<Education> optionalEducation = Optional.ofNullable(eduServ.findEducation(Long.valueOf(id)));
        if (optionalEducation.isPresent()) {
            Education edu = optionalEducation.get();
            if (!education.getName().isEmpty())
                edu.setName(education.getName());
            if (!education.getTitle().isEmpty())
                edu.setTitle(education.getTitle());
            if (education.getTimeStart() != null)
                edu.setTimeStart(education.getTimeStart());
            if (education.getTimeEnd() != null)
                edu.setTimeEnd(education.getTimeEnd());
            if (!education.getLocation().isEmpty())
                edu.setLocation(education.getLocation());
            if (!education.getImg().isEmpty())
                edu.setImg(education.getImg());
            if (!education.getUrl().isEmpty())
                edu.setUrl(education.getUrl());
            return new ResponseEntity<>(eduRepo.save(edu), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/edu/delete/{id}")
    public void deleteEducation(@PathVariable Long id) {
        eduServ.deleteEducation(id);
    }

    @GetMapping("/edu/get/{id}")
    @ResponseBody
    public Education findEducation(@PathVariable Long id) {
        return eduServ.findEducation(id);
    }
}
