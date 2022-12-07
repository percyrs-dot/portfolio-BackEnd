package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Skill;
import com.portfolio.BackEnd.service.ISkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SkillController {

    public final ISkillService skillServ;

    public SkillController(ISkillService skillServ) {
        this.skillServ = skillServ;
    }

    @PostMapping("/skill/post")
    public void updateSkill(@RequestBody Skill skl) {
        skillServ.updateSkill(skl);
    }

    @GetMapping("/skill/get")
    @ResponseBody
    public List<Skill> getSkill() {
        return skillServ.getSkill();
    }

    @DeleteMapping("/skill/delete/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillServ.deleteSkill(id);
    }

    @GetMapping("/skill/get/{id}")
    @ResponseBody
    public Optional<Skill> findSkill(@PathVariable Long id) {
        return skillServ.findSkill(id);
    }
}
