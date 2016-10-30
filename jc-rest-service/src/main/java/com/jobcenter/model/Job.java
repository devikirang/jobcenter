package com.jobcenter.model;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * This class represents job posting.
 */
public class Job {
    @Id
    private String id;
    private String jobHeading;
    private String jobDescription;
    private List<WeighedSkill> weighedSkills;
    private User recruiter;
    private User manager;
    private JobLocation jobLocation;
    private List<JobInterview> jobInterviews;
    private User selectedCandidate;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<WeighedSkill> getWeighedSkills() {
        return weighedSkills;
    }

    public void setWeighedSkills(List<WeighedSkill> weighedSkills) {
        this.weighedSkills = weighedSkills;
    }

    public User getRecruiter() {
        return recruiter;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double findSkillWeight(Skill skill) {
        return weighedSkills.stream().filter(weighedSkill -> weighedSkill.getSkill() == skill).findFirst().get().getWeight();
    }
}
