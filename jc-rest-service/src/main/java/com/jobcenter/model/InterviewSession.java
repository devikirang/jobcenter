package com.jobcenter.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created on 10/29/2016.
 * This class represents interview between an interviewer and an interviewee.
 */
public class InterviewSession {

    private User interviewer;
    private List<CandidateSkill> candidateSkills;

    public User getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(User interviewer) {
        this.interviewer = interviewer;
    }

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

}
