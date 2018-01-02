package com.company.quoll.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "intertypeRelations")
public class IntertypeRelation {

    @Id
    @Column(name = "relation_id")
    private int id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "fitnessOrder")
    private int fitnessOrder;

    @NotEmpty
    @Column(name = "description")
    @Lob
    private byte[] description;

    @OneToMany(mappedBy = "intertypeRelation")
    private Set<SocionicsRelationsMatch> socionicsRelationsMatchSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFitnessOrder() {
        return fitnessOrder;
    }

    public void setFitnessOrder(int fitnessOrder) {
        this.fitnessOrder = fitnessOrder;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    public Set<SocionicsRelationsMatch> getSocionicsRelationsMatchSet() {
        return socionicsRelationsMatchSet;
    }

    public void setSocionicsRelationsMatchSet(Set<SocionicsRelationsMatch> socionicsRelationsMatchSet) {
        this.socionicsRelationsMatchSet = socionicsRelationsMatchSet;
    }
}
