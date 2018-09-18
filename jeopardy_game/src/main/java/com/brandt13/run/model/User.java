package com.brandt13.run.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "Please provide a valid Email")
    @NotEmpty(message = "Please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide your password")
    @Transient
    private String password;
    @Column(name = "active")
    private int active;
    @Column(name = "high_score")
    private int high_score;
    @Column(name = "current_score")
    private int current_score = 0;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

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

    public int getHigh_score() {
        return high_score;
    }

    public void setHigh_score(int high_score) {
        this.high_score = high_score;
    }

    public int getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(int current_score) {
        this.current_score = current_score;
    }

    public User(int id, String email, String password, int active, int high_score, int current_score, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.active = active;
        this.high_score = high_score;
        this.current_score = current_score;
        this.roles = roles;
    }

    public User() {
    }
}