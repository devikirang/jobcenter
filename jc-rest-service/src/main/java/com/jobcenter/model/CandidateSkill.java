package com.jobcenter.model;

import org.springframework.data.annotation.Id;

/**
 * This class represents interviewee Skill level.
 */
public class CandidateSkill {

    @Id
    private String id;
    private User interviewee;
    private Skill skill;
    private double rating;

    public CandidateSkill() {
    }

    public CandidateSkill(User interviewee, Skill skill, double rating) {
        this.interviewee = interviewee;
        this.skill = skill;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public User getInterviewee() {
        return interviewee;
    }

    public Skill getSkill() {
        return skill;
    }

    /**
     * 1 - 10 Scale. 1 being lowest and 10 being highest scale.
     *
     * @return int value.
     */
    public double getRating() {
        return rating;
    }
}
