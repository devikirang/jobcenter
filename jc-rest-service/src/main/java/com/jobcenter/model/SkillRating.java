package com.jobcenter.model;

/**
 * This class represents Candidate Skill rating giving by an interviewer for a specific Skill.
 */
public class SkillRating {

    private Skill skill;
    private double rating;

    public SkillRating() {
    }

    public SkillRating(Skill skill, double rating) {
        this.skill = skill;
        this.rating = rating;
    }

    public Skill getSkill() {
        return skill;
    }

    /**
     * 0 - 5 Scale. 0 being lowest and 5 being highest rating.
     *
     * @return int value.
     */
    public double getRating() {
        return rating;
    }
}
