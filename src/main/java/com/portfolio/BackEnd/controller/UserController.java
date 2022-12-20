package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.User;
import com.portfolio.BackEnd.repository.UserRepository;
import com.portfolio.BackEnd.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    private final IUserService userServ;
    private final UserRepository userRepo;

    public UserController(IUserService userServ, UserRepository userRepo) {
        this.userServ = userServ;
        this.userRepo = userRepo;
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

    @PutMapping ("/user/put/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody User User) {
        Optional<User> optionalUser = Optional.ofNullable(userServ.findUser(Long.valueOf(id)));
        if (optionalUser.isPresent()) {
            User usr = optionalUser.get();
            if (!User.getName().isEmpty())
                usr.setName(User.getName());
            if (!User.getProfileBg().isEmpty())
                usr.setProfileBg(User.getProfileBg());
            if (!User.getProfilePic().isEmpty())
                usr.setProfilePic(User.getProfilePic());
            if (!User.getCurrentPosition().isEmpty())
                usr.setCurrentPosition(User.getCurrentPosition());
            if (!User.getLocation().isEmpty())
                usr.setLocation(User.getLocation());
            return new ResponseEntity<>(userRepo.save(usr), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping ("/about/put/{id}")
    public ResponseEntity<Object> updateAbout(@PathVariable("id" ) String id, @RequestBody User User) {
        Optional<User> optionalUser = Optional.ofNullable(userServ.findUser(Long.valueOf(id)));
        if (optionalUser.isPresent()) {
            User usr = optionalUser.get();
            if (!User.getAbout().isEmpty())
                usr.setAbout(User.getAbout());
            return new ResponseEntity<>(userRepo.save(usr), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServ.deleteUser(id);
    }

    @GetMapping("/user/get/{id}")
    @ResponseBody
    public User findUser(@PathVariable Long id) {
        return userServ.findUser(id);
    }
}
