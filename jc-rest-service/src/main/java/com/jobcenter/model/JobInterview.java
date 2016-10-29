package com.jobcenter.model;

import java.util.List;

/**
 * Created on 10/29/2016.
 * This class represents interview between an interviewer and an interviewee.
 */
public class JobInterview {

    private JobApplication jobApplication;
    private List<User> interviewers;
    private String notes;
    private List<JobInterviewComment> comments;

    private List<ScaledSkill> scaledSkills;
    private int intervieweeRank;

    public JobApplication getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(JobApplication jobApplication) {
        this.jobApplication = jobApplication;
    }

    public List<User> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<User> interviewers) {
        this.interviewers = interviewers;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<JobInterviewComment> getComments() {
        return comments;
    }

    public void setComments(List<JobInterviewComment> comments) {
        this.comments = comments;
    }

    public List<ScaledSkill> getScaledSkills() {
        return scaledSkills;
    }

    public void setScaledSkills(List<ScaledSkill> scaledSkills) {
        this.scaledSkills = scaledSkills;
    }

    public int getIntervieweeRank() {
        return intervieweeRank;
    }

    public void setIntervieweeRank(int intervieweeRank) {
        this.intervieweeRank = intervieweeRank;
    }
}
