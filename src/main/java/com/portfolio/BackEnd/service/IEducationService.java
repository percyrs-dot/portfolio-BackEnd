package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {

    List<Education> getEducation();

    void updateEducation(Education edu);

    void deleteEducation(Long id);

    Optional<Education> findEducation(Long id);
}
