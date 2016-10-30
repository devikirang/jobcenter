package com.jobcenter.web;

import com.jobcenter.model.DataResponse;
import com.jobcenter.model.Job;
import com.jobcenter.model.User;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.JobService;
import com.jobcenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created on 10/29/2016.
 */
@RestController
public class JobController {
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/allJobs", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse<List<Job>> allJobs() {
        logger.info("Getting all jobs");
        List<Job> allJobs = jobService.findAllJobs();
        return new DataResponse(allJobs);
    }
}
