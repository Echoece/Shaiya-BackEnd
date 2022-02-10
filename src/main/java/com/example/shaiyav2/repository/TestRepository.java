package com.example.shaiyav2.repository;

import com.example.shaiyav2.entity.UsersMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<UsersMaster,Integer> {
    @Procedure("dbo.web_UserRegistration")
    void createNewUser(String UserId, String Password, String Ip);

    @Query(value = "select * from dbo.Users_Master",nativeQuery = true)
    List<UsersMaster> allUsers();

    @Query(value = "select * from PS_UserData.dbo.Users_Master where Pw=:pw",nativeQuery = true)
    UsersMaster findUserByPassword(String pw);

    @Query(value = "select * from PS_UserData.dbo.Users_Master where UserId=:name",nativeQuery = true)
    UsersMaster userByJwt(String name);

}
