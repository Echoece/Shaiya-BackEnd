package com.example.shaiyav2.repository.usermaster;

import com.example.shaiyav2.entity.UsersMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMasterRepository extends JpaRepository<UsersMaster,Long> {

    UsersMaster getUsersMasterByUserId(String userName);
}
