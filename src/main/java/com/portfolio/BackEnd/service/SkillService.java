package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Skill;
import com.portfolio.BackEnd.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService {

    public final SkillRepository skillRepo;

    public SkillService(SkillRepository skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public List<Skill> getSkill() {
        return skillRepo.findAll();
    }

    @Override
    public void updateSkill(Skill skl) {
        skillRepo.save(skl);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }
}
