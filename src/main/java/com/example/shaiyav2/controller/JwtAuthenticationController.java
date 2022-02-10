package com.example.shaiyav2.controller;


import com.example.shaiyav2.configuration.jwt.JwtTokenUtil;
import com.example.shaiyav2.entity.auth.JwtRequest;
import com.example.shaiyav2.entity.auth.JwtResponse;
import com.example.shaiyav2.entity.auth.RegistrationConstraint;
import com.example.shaiyav2.entity.auth.UserDTO;
import com.example.shaiyav2.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/authenticate")      // login -> (name,password) , returns a jwt on success
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        // throws error if not authenticated
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final String token = GenerateTokenFromUserName(authenticationRequest.getUsername());

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register") // register a new user ,expects {username,password,email} object
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {

        String name = user.getUsername();
        String Email = user.getEmail();

        RegistrationConstraint registrationConstraint = userDetailsService.validatingNameAndEmail(name, Email);

        if (registrationConstraint.isEmail() && registrationConstraint.isUsername()) {
            userDetailsService.save(user);
            final String token = GenerateTokenFromUserName(name);
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.ok(registrationConstraint);
    }

    // authenticate user name and password
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    // getting token from user name
    private String GenerateTokenFromUserName(String userName) {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userName);
        return jwtTokenUtil.generateToken(userDetails);
    }
}
