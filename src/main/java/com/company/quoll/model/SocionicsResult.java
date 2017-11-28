package com.company.quoll.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "socionicsResults")
public class SocionicsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "extrovert_value")
    @NotBlank
    private float extrovert_value;
    @Column(name = "sensing_value")
    @NotBlank
    private float sensing_value;
    @Column(name = "thinking_value")
    @NotBlank
    private float thinking_value;
    @Column(name = "perceiving_value")
    @NotBlank
    private float perceiving_value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getExtrovert_value() {
        return extrovert_value;
    }

    public void setExtrovert_value(float extrovert_value) {
        this.extrovert_value = extrovert_value;
    }

    public float getSensing_value() {
        return sensing_value;
    }

    public void setSensing_value(float sensing_value) {
        this.sensing_value = sensing_value;
    }

    public float getThinking_value() {
        return thinking_value;
    }

    public void setThinking_value(float thinking_value) {
        this.thinking_value = thinking_value;
    }

    public float getPerceiving_value() {
        return perceiving_value;
    }

    public void setPerceiving_value(float perceiving_value) {
        this.perceiving_value = perceiving_value;
    }
}
