package com.jobcenter.model;

/**
 * Created on 10/29/2016.
 */
public class WeighedSkill {

    private Skill skill;
    private double weight;

    public WeighedSkill() {
    }

    public WeighedSkill(Skill skill, double weight) {
        this.skill = skill;
        this.weight = weight;
    }

    public Skill getSkill() {
        return skill;
    }

    public double getWeight() {
        return weight;
    }
}
