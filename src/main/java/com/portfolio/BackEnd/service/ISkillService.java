package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillService {

    List<Skill> getSkill();

    void updateSkill(Skill skl);

    void deleteSkill(Long id);

    Optional<Skill> findSkill(Long id);

}
