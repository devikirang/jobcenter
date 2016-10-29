package com.jobcenter.model;

import java.util.List;

/**
 * This class represents job posting.
 */
public class Job {
    private String jobHeading;
    private String jobDescription;
    private List<Skill> skills;
    private User recruiter;
    private JobLocation jobLocation;
    private List<JobInterview> jobInterviews;
    private User selectedCandidate;

    public String getJobHeading() {
        return jobHeading;
    }

    public void setJobHeading(String jobHeading) {
        this.jobHeading = jobHeading;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public User getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(User recruiter) {
        this.recruiter = recruiter;
    }

    public JobLocation getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public List<JobInterview> getJobInterviews() {
        return jobInterviews;
    }

    public void setJobInterviews(List<JobInterview> jobInterviews) {
        this.jobInterviews = jobInterviews;
    }

    public User getSelectedCandidate() {
        return selectedCandidate;
    }

    public void setSelectedCandidate(User selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }
}