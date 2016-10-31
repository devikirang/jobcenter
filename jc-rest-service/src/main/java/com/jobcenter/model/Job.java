package com.jobcenter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents job posting.
 */
public class Job {
    @Id
    private String id;
    private String jobCode;
    private String heading;
    private String description;
    private List<WeighedSkill> weighedSkills;
    private User recruiter;
    private User manager;
    private JobLocation jobLocation;

    @Transient
    private List<CandidateJob> candidateJobs;

    public Job() {
    }

    public Job(String jobCode, String heading, String description, User recruiter, User manager, JobLocation jobLocation) {
        this.jobCode = jobCode;
        this.heading = heading;
        this.description = description;
        this.recruiter = recruiter;
        this.manager = manager;
        this.jobLocation = jobLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double findSkillWeight(Skill skill) {
        return weighedSkills.stream().filter(weighedSkill -> weighedSkill.getSkill() == skill).findFirst().get().getWeight();
    }

    public List<CandidateJob> getCandidateJobs() {
        return candidateJobs;
    }

    public void setCandidateJobs(List<CandidateJob> candidateJobs) {
        this.candidateJobs = candidateJobs;
    }
}
