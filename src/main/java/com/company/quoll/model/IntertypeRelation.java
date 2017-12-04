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
    private int order;

    @NotEmpty
    @Column(name = "description")
    @Lob
    private byte[] description;

    @OneToMany(mappedBy = "intertypeRelation")
    private Set<SocinoicsRelationsMatch> socinoicsRelationsMatchSet;

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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    public Set<SocinoicsRelationsMatch> getSocinoicsRelationsMatchSet() {
        return socinoicsRelationsMatchSet;
    }

    public void setSocinoicsRelationsMatchSet(Set<SocinoicsRelationsMatch> socinoicsRelationsMatchSet) {
        this.socinoicsRelationsMatchSet = socinoicsRelationsMatchSet;
    }
}
