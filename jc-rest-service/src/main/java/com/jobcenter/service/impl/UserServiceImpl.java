package com.jobcenter.service.impl;

import com.jobcenter.dao.UserDao;
import com.jobcenter.model.User;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Created on 10/29/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Value("${app.corpEmailDomain}")
    private String corpEmailDomain;

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User registerUser(User userData) throws BusinessException {
        if (userData.getEmail() == null || userData.getPassword() == null) {
            throw new BusinessException("Missing Required User Data: email or password.");
        }
        // if user is manager or recruiter then make sure the email domain is Corp email.
        if (!userData.isInterviewee()) {
            if (!userData.getEmail().toLowerCase().endsWith(corpEmailDomain)) {
                throw new BusinessException("Invalid registration. You can't register with that Role.");
            }
        }
        User anyUser = userDao.findByEmail(userData.getEmail());
        if (anyUser != null) {
            throw new BusinessException("User already exits.");
        }
        return userDao.save(userData);
    }

    @Override
    public User loginUser(String email, String password) throws BusinessException {
        User user = userDao.findOne(Example.of(new User(email, password)));
        if (user == null || user.getId() == null) {
            throw new BusinessException("Invalid login.");
        }
        return user;
    }
}
