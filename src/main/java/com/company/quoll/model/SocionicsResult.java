package com.company.quoll.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "socionicsResults")
public class SocionicsResult {
    @Id
    @Column(name = "result_id")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "extrovert_value")
    @NotNull
    private float extrovertValue;
    @Column(name = "sensing_value")
    @NotNull
    private float sensingValue;
    @Column(name = "thinking_value")
    @NotNull
    private float thinkingValue;
    @Column(name = "perceiving_value")
    @NotNull
    private float perceivingValue;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public SocionicsResult(UUID id, float extrovertValue, float sensingValue, float thinkingValue, float perceivingValue) {
        this.id = id;
        this.extrovertValue = extrovertValue;
        this.sensingValue = sensingValue;
        this.thinkingValue = thinkingValue;
        this.perceivingValue = perceivingValue;
    }

    public SocionicsResult() {
    }

    @Override
    public String toString() {
        return String.format("SocionicsResult { e: %f, s: %f, t: %f, p: %f }",
                extrovertValue, sensingValue, thinkingValue, perceivingValue);
    }
}
