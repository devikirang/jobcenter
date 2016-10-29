package com.jobcenter.model;

import org.springframework.data.annotation.Id;

/**
 * This class represents interviewee Skill level.
 */
public class ScaledSkill {

    @Id
    private String id;
    private User interviewee;
    private Skill skill;
    private int scale;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    /**
     * 1 - 10 Scale. 1 being lowest and 10 being highest scale.
     * @return int value.
     */
    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
