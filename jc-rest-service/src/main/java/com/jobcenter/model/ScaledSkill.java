package com.jobcenter.model;

/**
 * This class represents interviewee Skill level.
 */
public class ScaledSkill {

    private User interviewee;
    private Skill skill;
    private int scale;

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
