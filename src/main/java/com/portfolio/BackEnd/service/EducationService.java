package com.portfolio.BackEnd.service;


import com.portfolio.BackEnd.model.Education;
import com.portfolio.BackEnd.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {

    private final EducationRepository eduRepo;

    public EducationService(EducationRepository eduRepo) {
        this.eduRepo = eduRepo;
    }

    @Override
    public List<Education> getEducation() {
        return eduRepo.findAll();
    }

    @Override
    public void updateEducation(Education edu) {
        eduRepo.save(edu);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

}