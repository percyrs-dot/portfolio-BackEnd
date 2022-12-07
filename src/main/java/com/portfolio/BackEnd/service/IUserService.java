package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getUser();

    void updateUser(User usr);

    void deleteUser(Long id);

    Optional<User> findUser(Long id);
}
