package com.company.quoll.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "socionicsRelationsMatches")
public class SocinoicsRelationsMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "socionicsRelationsMatch_id")
    private int id;

    @NotEmpty
    @Column(name = "typeA")
    private String typeA;

    @NotEmpty
    @Column(name = "typeB")
    private String typeB;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = IntertypeRelation.class)
    @JoinColumn(name = "relation_id")
    private IntertypeRelation intertypeRelation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public IntertypeRelation getIntertypeRelation() {
        return intertypeRelation;
    }

    public void setIntertypeRelation(IntertypeRelation intertypeRelation) {
        this.intertypeRelation = intertypeRelation;
    }
}
