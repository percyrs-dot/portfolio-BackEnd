package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Experience;
import com.portfolio.BackEnd.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements IExperienceService {

    public final ExperienceRepository expRepo;

    public ExperienceService(ExperienceRepository expRepo) {
        this.expRepo = expRepo;
    }

    @Override
    public List<Experience> getExperience() {
        return expRepo.findAll();
    }

    @Override
    public void updateExperience(Experience exp) {
        expRepo.save(exp);
    }

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        return expRepo.findById(id).orElse(null);
    }
}
