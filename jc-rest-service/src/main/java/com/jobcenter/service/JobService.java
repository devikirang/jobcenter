package com.jobcenter.service;

import com.jobcenter.model.Job;
import com.jobcenter.model.User;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
public interface JobService {
    Job createNewJob(Job job) throws BusinessException;

    List<Job> findAllJobs();
}