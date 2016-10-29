package com.jobcenter.web;

import com.jobcenter.model.Role;
import com.jobcenter.model.DataResponse;
import com.jobcenter.model.User;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 10/29/2016.
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/registerCandidate", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<User> registerCandidate(@RequestBody User userData) {
        userData.setRole(Role.INTERVIEWEE);
        return registerUser(userData);
    }

    @RequestMapping(value = "/registerRecruiter", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<User> registerRecruiter(@RequestBody User userData) {
        userData.setRole(Role.RECURITER);
        return registerUser(userData);
    }

    @RequestMapping(value = "/registerManager", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<User> registerManager(@RequestBody User userData) {
        userData.setRole(Role.MANAGER);
        return registerUser(userData);
    }

    private DataResponse<User> registerUser(@RequestBody User userData) {
        try {
            User savedUser = userService.registerUser(userData);
            return new DataResponse(savedUser);
        } catch (BusinessException e) {
            logger.error("Failed to register the user", e);
            return new DataResponse(e.getMessage());
        }
    }

    @RequestMapping("/user")
    public User findUserByEmail(@RequestParam(value="email") String email) {
        return userService.findUserByEmail(email);
    }
}
