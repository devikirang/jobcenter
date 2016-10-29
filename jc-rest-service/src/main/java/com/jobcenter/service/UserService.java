package com.jobcenter.service;

import com.jobcenter.model.User;

/**
 * Created by SG0218287 on 10/29/2016.
 */
public interface UserService {

    public User findUserByEmail(String email);

    User registerUser(User userData) throws BusinessException;
}
