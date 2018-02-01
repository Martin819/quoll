package com.company.quoll.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "address_id")
    private String id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "nuts_level")
    private int nutsLevel;

    @NotNull
    @Column(name = "country_code")
    private String countryCode;

/*    @OneToMany(mappedBy = "address_id", targetEntity = Set.class)
    private Set<User> usersSet;*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNutsLevel() {
        return nutsLevel;
    }

    public void setNutsLevel(int nutsLevel) {
        this.nutsLevel = nutsLevel;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

/*    public Set<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<User> usersSet) {
        this.usersSet = usersSet;
    }*/
}
