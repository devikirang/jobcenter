package com.jobcenter.web;

import com.jobcenter.model.DataResponse;
import com.jobcenter.model.InterviewSession;
import com.jobcenter.model.Job;
import com.jobcenter.model.User;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.CandidateJobService;
import com.jobcenter.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 10/29/2016.
 */
@RestController
public class JobController {
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobService jobService;

    @Autowired
    private CandidateJobService candidateJobService;

    @RequestMapping(value = "/allJobs", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse<List<Job>> allJobs() {
        logger.info("Getting all jobs");
        List<Job> allJobs = jobService.findAllJobs();
        return new DataResponse(allJobs);
    }

    @RequestMapping(value = "/myInterviews", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<InterviewSession>> findMyInterviewSessions(@RequestBody User interviewer) {
        logger.info("Getting all candidates Interview Sessions conducted by an interviewer =" + interviewer.getEmail());
        try {
            List<InterviewSession> interviewSessions = candidateJobService.findMyInterviewSessions(interviewer);
            return new DataResponse(interviewSessions);
        } catch (BusinessException e) {
            return new DataResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/interviewResults", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<Job>> findAllMyJobsInterviewResults(@RequestBody User managerUser) {
        logger.info("Getting all Candidates Job Interview Details");
        try {
            List<Job> jobs = candidateJobService.findAllMyJobsInterviewResults(managerUser);
            return new DataResponse(jobs);
        } catch (BusinessException e) {
            return new DataResponse(e.getMessage());
        }
    }
}
