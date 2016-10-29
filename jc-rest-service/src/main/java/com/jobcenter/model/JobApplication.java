package com.jobcenter.model;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created on 10/29/2016.
 * This class represents job posting by interviewee.
 * And also holds comments, notes from the
 */
public class JobApplication {
    @Id
    private String id;
    private User interviewee;
    private Job job;
    private byte[] resume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(User interviewee) {
        this.interviewee = interviewee;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }
}
