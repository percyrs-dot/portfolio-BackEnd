package com.portfolio.BackEnd.service;


import com.portfolio.BackEnd.model.Education;

import java.util.List;

public interface IEducationService {

    List<Education> getEducation();

    void updateEducation(Education edu);

    void deleteEducation(Long id);

    Education findEducation(Long id);

}
