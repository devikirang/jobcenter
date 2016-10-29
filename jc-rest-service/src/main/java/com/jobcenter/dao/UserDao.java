package com.jobcenter.dao;

import com.jobcenter.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 10/29/2016.
 */
public interface UserDao extends MongoRepository<User, String> {
    public User findById(String id);

    public User findByEmail(String email);
}
