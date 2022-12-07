package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Experience;
import com.portfolio.BackEnd.service.IExperienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExperienceController {

    public final IExperienceService expServ;

    public ExperienceController(IExperienceService expServ) {
        this.expServ = expServ;
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

    @DeleteMapping("/exp/delete/{id}")
    public void deleteExperience(@PathVariable Long id) {
        expServ.deleteExperience(id);
    }

    @GetMapping("/exp/get/{id}")
    @ResponseBody
    public Optional<Experience> findExperience(@PathVariable Long id) {
        return expServ.findExperience(id);
    }
}
