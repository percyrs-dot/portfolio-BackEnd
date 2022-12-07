package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.User;
import com.portfolio.BackEnd.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    public final IUserService userServ;

    public UserController(IUserService userServ) {
        this.userServ = userServ;
    }

    @PostMapping("/user/post")
    public void updateUser(@RequestBody User usr) {
        userServ.updateUser(usr);
    }

    @GetMapping("/user/get")
    @ResponseBody
    public List<User> getUser() {
        return userServ.getUser();
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServ.deleteUser(id);
    }

    @GetMapping("/user/get/{id}")
    @ResponseBody
    public Optional<User> findUser(@PathVariable Long id) {
        return userServ.findUser(id);
    }
}
