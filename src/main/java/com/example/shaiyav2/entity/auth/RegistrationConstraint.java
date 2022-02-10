package com.example.shaiyav2.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class RegistrationConstraint {
    private boolean username;
    private boolean email;

    public RegistrationConstraint(boolean name, boolean email) {
        this.username = name;
        this.email = email;
    }
}
