package com.jobcenter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 10/29/2016.
 * This class represents interview between an interviewer and an interviewee.
 */
public class InterviewSession {

    private User interviewer;
    private List<SkillRating> skillRatings;
    private String comments;

    public InterviewSession() {
    }

    public InterviewSession(User interviewer, List<SkillRating> skillRatings) {
        this.interviewer = interviewer;
        this.skillRatings = skillRatings;
    }

    public User getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(User interviewer) {
        this.interviewer = interviewer;
    }

    public List<SkillRating> getSkillRatings() {
        if (skillRatings == null) {
            skillRatings = new ArrayList();
        }
        return skillRatings;
    }

    public void setSkillRatings(List<SkillRating> skillRatings) {
        this.skillRatings = skillRatings;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
