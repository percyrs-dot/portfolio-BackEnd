package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.User;

import java.util.List;

public interface IUserService {

    List<User> getUser();

    void updateUser(User usr);

    void deleteUser(Long id);

    User findUser(Long id);
}
