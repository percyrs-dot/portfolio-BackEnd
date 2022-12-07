package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {

    List<Experience> getExperience();

    void updateExperience(Experience exp);

    void deleteExperience(Long id);

    Optional<Experience> findExperience(Long id);
}
