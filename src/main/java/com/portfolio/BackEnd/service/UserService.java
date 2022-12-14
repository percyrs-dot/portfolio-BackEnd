package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.User;
import com.portfolio.BackEnd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    public final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getUser() {
        return userRepo.findAll();
    }

    @Override
    public void updateUser(User usr) {
        userRepo.save(usr);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User findUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
