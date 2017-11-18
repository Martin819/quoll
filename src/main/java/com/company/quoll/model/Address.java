package com.company.quoll.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int id;
    @Column(name = "NUTS0")
    @NotEmpty(message = "Please provide your country")
    private String NUTS0;
    @Column(name = "NUTS1")
    @NotEmpty(message = "Please provide your state")
    private String NUTS1;
    @Column(name = "NUTS2")
    @NotEmpty(message = "Please provide your region")
    private String NUTS2;
    @Column(name = "NUTS3")
    @NotEmpty(message = "Please provide your province")
    private String NUTS3;
    @OneToMany(mappedBy = "address")
    private Set<User> users;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNUTS0() {
        return NUTS0;
    }

    public void setNUTS0(String NUTS0) {
        this.NUTS0 = NUTS0;
    }

    public String getNUTS1() {
        return NUTS1;
    }

    public void setNUTS1(String NUTS1) {
        this.NUTS1 = NUTS1;
    }

    public String getNUTS2() {
        return NUTS2;
    }

    public void setNUTS2(String NUTS2) {
        this.NUTS2 = NUTS2;
    }

    public String getNUTS3() {
        return NUTS3;
    }

    public void setNUTS3(String NUTS3) {
        this.NUTS3 = NUTS3;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
