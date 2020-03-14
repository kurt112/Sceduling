package com.school.scheduling.entity;

import javax.persistence.*;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 29 2020
 * 12:27 AM
 */
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "username",nullable = false, columnDefinition="VARCHAR(64)")
    private String users;

    @Column(name = "authority")
    private String role;

    public Authorities() {
    }

    public Authorities(String username,String role) {
        users = username;
        this.role = role;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "users='" + users + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
