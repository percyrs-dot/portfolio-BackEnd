package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Experience;

import java.util.List;

public interface IExperienceService {

    List<Experience> getExperience();

    void updateExperience(Experience exp);

    void deleteExperience(Long id);

    Experience findExperience(Long id);
}
