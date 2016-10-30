package com.jobcenter.service;

import com.jobcenter.model.CandidateJob;
import com.jobcenter.model.Job;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
public interface CandidateJobService {
    List<CandidateJob> findAllCandidateJobsByJobCode(String jobCode) throws BusinessException;
}
