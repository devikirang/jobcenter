package com.jobcenter.service;

import com.jobcenter.model.Job;

/**
 * Created on 10/29/2016.
 */
public interface JobService {
    Job createNewJob(Job job) throws BusinessException;
}
