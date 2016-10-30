package com.jobcenter.service;

import com.jobcenter.model.CandidateJob;
import com.jobcenter.model.Job;
import com.jobcenter.model.User;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
public interface CandidateJobService {
    List<CandidateJob> findAllCandidateJobsByJobCode(String jobCode, User requestedUser) throws BusinessException;
}
