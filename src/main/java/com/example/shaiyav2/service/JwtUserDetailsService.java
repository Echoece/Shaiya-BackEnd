package com.example.shaiyav2.service;

import com.example.shaiyav2.entity.auth.DAOUser;
import com.example.shaiyav2.entity.auth.RegistrationConstraint;
import com.example.shaiyav2.entity.auth.UserDTO;
import com.example.shaiyav2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository userRepositoryDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userRepositoryDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // getting roles, to be exact only one role. but i can play around here to fix roles. Also for larger
        // project, role hierarchy is the way to go.
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+userRepositoryDao.findDAOUserByUsername(username).getRole();
            }
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    // getting roles
    public String getRoleByUsername(String username){
        return userRepositoryDao.findDAOUserByUsername(username).getRole();
    }

    // saving new user, for registration controller uses
    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setRole("player");
        newUser.setStatus("Normal");
        return userRepositoryDao.save(newUser);
    }

    // validating registration uniqueness
    public RegistrationConstraint validatingNameAndEmail(String username, String email){
        boolean isEmailUnique = !userRepositoryDao.existsByEmail(email);
        boolean isNameUnique = !userRepositoryDao.existsByUsername(username);

        RegistrationConstraint registrationConstraintError = new RegistrationConstraint(isNameUnique,isEmailUnique);

        return registrationConstraintError;
    }
}
