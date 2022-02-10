package com.example.shaiyav2;

import lombok.Getter;
import lombok.Setter;

// used for testing purpose , not used in application
@Getter @Setter
public class User {
    private String name,password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
