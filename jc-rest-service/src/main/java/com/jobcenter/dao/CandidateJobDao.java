package com.jobcenter.dao;

import com.jobcenter.model.CandidateJob;
import com.jobcenter.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created on 10/30/2016.
 */
public interface CandidateJobDao extends MongoRepository<CandidateJob, String> {
    public List<CandidateJob> findAllByJobCode(String jobCode);
}
