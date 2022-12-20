package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Skill;
import com.portfolio.BackEnd.repository.SkillRepository;
import com.portfolio.BackEnd.service.ISkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SkillController {

    private final ISkillService skillServ;
    private final SkillRepository skillRepo;

    public SkillController(ISkillService skillServ, SkillRepository skillRepo) {
        this.skillServ = skillServ;
        this.skillRepo = skillRepo;
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

    @PutMapping ("/skill/put/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody Skill Skill) {
        Optional<Skill> optionalSkill = Optional.ofNullable(skillServ.findSkill(Long.valueOf(id)));
        if (optionalSkill.isPresent()) {
            Skill skl = optionalSkill.get();
            if (!Skill.getName().isEmpty())
                skl.setName(Skill.getName());
            if (Skill.getLevel() != null)
                skl.setLevel(Skill.getLevel());
            return new ResponseEntity<>(skillRepo.save(skl), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/skill/delete/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillServ.deleteSkill(id);
    }

    @GetMapping("/skill/get/{id}")
    @ResponseBody
    public Skill findSkill(@PathVariable Long id) {
        return skillServ.findSkill(id);
    }
}
