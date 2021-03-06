package com.company.quoll.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username", unique = true)
    @Length(min = 5, message = "*Username must have at least 5 characters")
    @NotBlank(message = "*Please fill in your username")
    private String username;

    @Column(name = "sex")
    @NotBlank(message = "Please select your sex")
    private String sex;

    @Column(name = "email", unique = true)
    @Email(message = "*Please fill in a valid e-mail")
    @NotBlank(message = "*Please fill in your e-mail")
    private String email;

    @Column(name = "password")
    @Length(min = 8, message = "*Password must have at least 8 characters")
    @NotBlank(message = "*Please fill in your password")
    private String password;

    @Column(name = "date_of_birth")
    @NotNull(message = "*Please fill in your date of birth.")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "zodiac_sign")
    private Integer zodiacSign;

    @Column(name = "socionics_type")
    private String socionicsType;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private SocionicsResult socionicsResult;

    @NotBlank(message = "*Please select the place of your stay.")
    @Transient
    private String addressCode;

    @NotBlank(message = "*Please fill the password twice.")
    @Transient
    private String repeatPassword;

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(Integer zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getSocionicsType() {
        return socionicsType;
    }

    public void setSocionicsType(String socionicsType) {
        this.socionicsType = socionicsType;
    }

    public SocionicsResult getSocionicsResult() {
        return socionicsResult;
    }

    public void setSocionicsResult(SocionicsResult socionicsResult) {
        this.socionicsResult = socionicsResult;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
