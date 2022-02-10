package com.example.shaiyav2.controller;

import com.example.shaiyav2.User;
import com.example.shaiyav2.configuration.jwt.JwtTokenUtil;
import com.example.shaiyav2.entity.UsersMaster;
import com.example.shaiyav2.entity.gamedata.RankCharData;
import com.example.shaiyav2.entity.gamedefs.Items;
import com.example.shaiyav2.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {

    private TestService testService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public Test(TestService testService, JwtTokenUtil jwtTokenUtil) {
        this.testService = testService;
        this.jwtTokenUtil=jwtTokenUtil;
    }

    @GetMapping("/hello")
    public UsersMaster SayHello(@RequestHeader(name="Authorization") String token){
       User user= new User("name","password");
       // getting username from token.
       String jwtToken =token.split(" ")[1];
       String userName= jwtTokenUtil.getUsernameFromToken(jwtToken);
       return  testService.getUserbyJwt(userName);
    }

    @GetMapping("/test/{id}")
    public int sayHi(@PathVariable int id){
        return id;
    }

    @GetMapping("/test2")
    public List<Items> say() throws SQLException {
         return testService.findAll();
    }

    @GetMapping("/chars")
    public List<RankCharData> allChar() {
        return testService.allChars();
    }

}
