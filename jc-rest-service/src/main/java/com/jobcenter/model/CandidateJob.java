package com.jobcenter.model;

import org.springframework.data.annotation.Id;

import java.util.*;

/**
 * Created on 10/29/2016.
 */
public class CandidateJob {
    @Id
    private String id;

    private User candidate;
    private String jobCode;
    private byte[] resume;
    private Date scheduledDate;
    private List<InterviewSession> interviewSessions;
    private String notes;
    private double candidateScore;

    public CandidateJob() {
    }

    public CandidateJob(User candidate, String jobCode, Date scheduledDate) {
        this.candidate = candidate;
        this.jobCode = jobCode;
        this.scheduledDate = scheduledDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public User getCandidate() {
        return candidate;
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<InterviewSession> getInterviewSessions() {
        if(interviewSessions == null) {
            interviewSessions = new ArrayList();
        }
        return interviewSessions;
    }

    public void setInterviewSessions(List<InterviewSession> interviewSessions) {
        this.interviewSessions = interviewSessions;
    }

    public double getCandidateScore() {
        return candidateScore;
    }

    public void setCandidateScore(double candidateScore) {
        this.candidateScore = candidateScore;
    }
}
