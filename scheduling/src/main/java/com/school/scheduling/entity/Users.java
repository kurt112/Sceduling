package com.school.scheduling.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 29 2020
 * 12:27 AM
 */
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "username", nullable = false, columnDefinition="VARCHAR(64)")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @OneToMany(mappedBy = "users" , orphanRemoval = true)
    private List<Authorities> authorities;

    public void add_Role(Authorities theauthorities){
        if(authorities == null) authorities = new ArrayList<>();
        authorities.add(theauthorities);
    }

    public Users() {        
    }

    public Users(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
