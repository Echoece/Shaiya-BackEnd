package com.example.shaiyav2.controller;

import com.example.shaiyav2.entity.gamedata.RankCharData;
import com.example.shaiyav2.service.rank.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rank")
@CrossOrigin
public class RankController {
    @Autowired
    RankService rankService;

    @GetMapping("/all")
    public List<RankCharData> allData(){
        return rankService.rankData();
    }
}
