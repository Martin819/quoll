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
    @Column(name = "nuts0")
    @NotEmpty(message = "Please provide your country")
    private String nuts0;
    @Column(name = "nuts1")
    @NotEmpty(message = "Please provide your state")
    private String nuts1;
    @Column(name = "nuts2")
    @NotEmpty(message = "Please provide your region")
    private String nuts2;
    @Column(name = "nuts3")
    @NotEmpty(message = "Please provide your province")
    private String nuts3;
    @OneToMany(mappedBy = "address")
    private Set<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNuts0() {
        return nuts0;
    }

    public void setNuts0(String nuts0) {
        this.nuts0 = nuts0;
    }

    public String getNuts1() {
        return nuts1;
    }

    public void setNuts1(String NUTS1) {
        this.nuts1 = NUTS1;
    }

    public String getNuts2() {
        return nuts2;
    }

    public void setNuts2(String nuts2) {
        this.nuts2 = nuts2;
    }

    public String getNuts3() {
        return nuts3;
    }

    public void setNuts3(String nuts3) {
        this.nuts3 = nuts3;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
