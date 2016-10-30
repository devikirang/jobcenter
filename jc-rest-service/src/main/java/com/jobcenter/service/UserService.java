package com.jobcenter.service;

import com.jobcenter.model.DataResponse;
import com.jobcenter.model.User;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
public interface UserService {

    User findUserByEmail(String email);

    User registerUser(User userData) throws BusinessException;

    User loginUser(String email, String password) throws BusinessException;

    List<User> findAllUsers();
}
