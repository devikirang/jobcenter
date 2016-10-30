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
        setWeight(weight);
    }

    public void setWeight(double weight) {
        // minimum weight is 1 and max is 5.
        if (weight <= 0) {
            this.weight = 1;
        } else if (weight > 5) {
            this.weight = 5;
        } else {
            this.weight = weight;
        }
    }

    public Skill getSkill() {
        return skill;
    }

    public double getWeight() {
        return weight;
    }
}
