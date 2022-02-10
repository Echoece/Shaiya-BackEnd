package com.example.shaiyav2.repository;

import com.example.shaiyav2.entity.auth.DAOUser;
import com.example.shaiyav2.entity.auth.RoleOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<DAOUser,Integer> {
    DAOUser findByUsername(String userName);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    RoleOnly findDAOUserByUsername(String UserId);
}
