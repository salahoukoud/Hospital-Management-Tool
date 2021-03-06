package com.revature.controllers;

import com.revature.service.UserService;
import com.revature.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sibrian on 2/15/17.
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/save",
                    method = RequestMethod.POST,
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user/getAll",
                    method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user/search/id/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable int id) {
        return userService.findOne(id);
    }

    @RequestMapping(value = "/user/search/name/{lName}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public User findByLastName(@PathVariable String lName) {
        return userService.findByLastName(lName);
    }
}
