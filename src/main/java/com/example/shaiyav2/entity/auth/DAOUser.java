package com.example.shaiyav2.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Setter
@Getter
public class DAOUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "details")
    private String details;

    public DAOUser() {
    }
}
