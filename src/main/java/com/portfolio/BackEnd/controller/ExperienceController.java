package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Experience;

import com.portfolio.BackEnd.repository.ExperienceRepository;
import com.portfolio.BackEnd.service.IExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ExperienceController {

    private final IExperienceService expServ;
    private final ExperienceRepository expRepo;

    public ExperienceController(IExperienceService expServ, ExperienceRepository expRepo) {
        this.expServ = expServ;
        this.expRepo = expRepo;
    }

    @PostMapping("/exp/post")
    public void updateExperience(@RequestBody Experience exp) {
        expServ.updateExperience(exp);
    }

    @GetMapping("/exp/get")
    @ResponseBody
    public List<Experience> getExperience() {
        return expServ.getExperience();
    }

    @PutMapping ("/exp/put/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody Experience experience) {
        Optional<Experience> optionalExperience = Optional.ofNullable(expServ.findExperience(Long.valueOf(id)));
        if (optionalExperience.isPresent()) {
            Experience exp = optionalExperience.get();
            if (!experience.getName().isEmpty())
                exp.setName(experience.getName());
            if (!experience.getPosition().isEmpty())
                exp.setPosition(experience.getPosition());
            if (experience.getTimeStart() != null)
                exp.setTimeStart(experience.getTimeStart());
            if (experience.getTimeEnd() != null)
                exp.setTimeEnd(experience.getTimeEnd());
            if (!experience.getLocation().isEmpty())
                exp.setLocation(experience.getLocation());
            if (!experience.getImg().isEmpty())
                exp.setImg(experience.getImg());
            if (!experience.getUrl().isEmpty())
                exp.setUrl(experience.getUrl());
            return new ResponseEntity<>(expRepo.save(exp), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/exp/delete/{id}")
    public void deleteExperience(@PathVariable Long id) {
        expServ.deleteExperience(id);
    }

    @GetMapping("/exp/get/{id}")
    @ResponseBody
    public Experience findExperience(@PathVariable Long id) {
        return expServ.findExperience(id);
    }
}
