package com.jobcenter.service;

import com.jobcenter.model.CandidateJob;
import com.jobcenter.model.InterviewSession;
import com.jobcenter.model.Job;
import com.jobcenter.model.User;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
public interface CandidateJobService {
    List<Job> findAllMyJobsInterviewResults(User managerUser) throws BusinessException;

    List<InterviewSession> findMyInterviewSessions(User interviewer) throws BusinessException;

    List<Job> findMyAppliedJobs(User candidate) throws BusinessException;
}
