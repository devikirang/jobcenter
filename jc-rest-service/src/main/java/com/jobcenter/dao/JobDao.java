package com.jobcenter.dao;

import com.jobcenter.model.Job;
import com.jobcenter.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 10/29/2016.
 */
public interface JobDao extends MongoRepository<Job, String> {
    public Job findByJobCode(String jobCode);
}
