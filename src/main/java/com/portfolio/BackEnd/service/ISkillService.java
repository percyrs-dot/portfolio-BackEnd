package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Skill;

import java.util.List;

public interface ISkillService {

    List<Skill> getSkill();

    void updateSkill(Skill skl);

    void deleteSkill(Long id);

    Skill findSkill(Long id);

}
