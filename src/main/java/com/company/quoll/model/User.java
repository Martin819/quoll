package com.company.quoll.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "username")
    @Length(min = 4, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "Please provide your username")
    private String username;
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 8, message = "*Your password must have at least 8 characters")
    @NotEmpty(message = "*Please provide your password")
    @Transient
    private String password;
    @Column(name = "date_of_birth")
    @NotEmpty(message = "Please provide your date of birth. It will not be visible to other users unless you specify otherwise.")
    private Date date_of_birth;
    @Column(name = "zodiac_sign")
    private String zodiac_sign;
    @Column(name = "socionics_type")
    private String socionics_type;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id")
    private Address address_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "socionics_results")
    private SocionicsResult socionics_result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Address getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Address address_id) {
        this.address_id = address_id;
    }

    public String getZodiac_sign() {
        return zodiac_sign;
    }

    public void setZodiac_sign(String zodiac_sign) {
        this.zodiac_sign = zodiac_sign;
    }

    public String getSocionics_type() {
        return socionics_type;
    }

    public void setSocionics_type(String socionics_type) {
        this.socionics_type = socionics_type;
    }

    public SocionicsResult getSocionics_result() {
        return socionics_result;
    }

    public void setSocionics_result(SocionicsResult socionics_result) {
        this.socionics_result = socionics_result;
    }
}
