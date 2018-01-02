package com.company.quoll.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "socionicsResults")
public class SocionicsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "extrovert_value")
    @NotBlank
    private float extrovertValue;
    @Column(name = "sensing_value")
    @NotBlank
    private float sensingValue;
    @Column(name = "thinking_value")
    @NotBlank
    private float thinkingValue;
    @Column(name = "perceiving_value")
    @NotBlank
    private float perceivingValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getExtrovertValue() {
        return extrovertValue;
    }

    public void setExtrovertValue(float extrovertValue) {
        this.extrovertValue = extrovertValue;
    }

    public float getSensingValue() {
        return sensingValue;
    }

    public void setSensingValue(float sensingValue) {
        this.sensingValue = sensingValue;
    }

    public float getThinkingValue() {
        return thinkingValue;
    }

    public void setThinkingValue(float thinkingValue) {
        this.thinkingValue = thinkingValue;
    }

    public float getPerceivingValue() {
        return perceivingValue;
    }

    public void setPerceivingValue(float perceivingValue) {
        this.perceivingValue = perceivingValue;
    }
}
