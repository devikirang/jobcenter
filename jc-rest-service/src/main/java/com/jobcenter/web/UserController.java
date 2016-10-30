package com.jobcenter.web;

import com.jobcenter.model.Job;
import com.jobcenter.model.Role;
import com.jobcenter.model.DataResponse;
import com.jobcenter.model.User;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created on 10/29/2016.
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<User> registerUser(@RequestBody User userData) {
        try {
            User savedUser = userService.registerUser(userData);
            return new DataResponse(savedUser);
        } catch (BusinessException e) {
            logger.error("Failed to register the user", e);
            return new DataResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse<List<User>> allJobs() {
        logger.info("Getting all users");
        List<User> allUsers = userService.findAllUsers();
        return new DataResponse(allUsers);
    }

    @RequestMapping("/user")
    public DataResponse<User> findUserByEmail(@RequestParam(value = "email") String email) {
        return new DataResponse(userService.findUserByEmail(email));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<User> loginUser(@RequestBody User userData) {
        try {
            User savedUser = userService.loginUser(userData.getEmail(), userData.getPassword());
            return new DataResponse(savedUser);
        } catch (BusinessException e) {
            logger.error("Login failed", e);
            return new DataResponse(e.getMessage());
        }
    }/*

    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Vary", "Accept");
    }*/
}
