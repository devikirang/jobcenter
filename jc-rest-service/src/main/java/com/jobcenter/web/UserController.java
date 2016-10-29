package com.jobcenter.web;

import com.jobcenter.model.User;
import com.jobcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 10/29/2016.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User getUser(@RequestParam(value="id") long id) {
        return userService.getUser(id);
    }
}
