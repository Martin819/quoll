package com.company.quoll.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class RegistrationForm {

    @NotEmpty(message = "Please fill in your username.")
    private String username;

    @NotNull(message = "Please fill in your date of birth.")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotEmpty(message = "Please select country.")
    private String nuts0;

    @NotEmpty(message = "Please select state.")
    private String nuts1;

    @NotEmpty(message = "Please select region.")
    private String nuts2;

    @NotEmpty(message = "Please select province.")
    private String nuts3;

    @NotEmpty(message = "Please fill in your email.")
    private String email;

    @NotEmpty(message = "Please fill in your password.")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public void setNuts1(String nuts1) {
        this.nuts1 = nuts1;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
