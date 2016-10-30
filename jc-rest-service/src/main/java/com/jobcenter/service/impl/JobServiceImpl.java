package com.jobcenter.service.impl;

import com.jobcenter.dao.JobDao;
import com.jobcenter.model.CandidateJob;
import com.jobcenter.model.Job;
import com.jobcenter.model.User;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public Job createNewJob(Job jobData) throws BusinessException {
        Job anyJob = jobDao.findByJobCode(jobData.getJobCode());
        if (anyJob != null) {
            throw new BusinessException("Job Code already exits. Use different code.");
        }
        return jobDao.save(jobData);
    }

    @Override
    public List<Job> findAllJobs() {
        return jobDao.findAll();
    }

}