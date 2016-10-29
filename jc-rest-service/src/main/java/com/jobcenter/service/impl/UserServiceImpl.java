package com.jobcenter.service.impl;

import com.jobcenter.model.User;
import com.jobcenter.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by SG0218287 on 10/29/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(long id) {
        User user = new User();
        user.setEmail("test@test.com");
        user.setName("test");
        user.setId(1);
        return user;
    }
}
