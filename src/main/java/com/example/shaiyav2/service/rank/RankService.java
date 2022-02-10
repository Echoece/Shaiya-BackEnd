package com.example.shaiyav2.service.rank;

import com.example.shaiyav2.entity.gamedata.RankCharData;
import com.example.shaiyav2.repository.gamedata.CharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    @Autowired
    private CharRepository charRepository;

    public List<RankCharData> rankData(){
        //Pageable pageable = PageRequest.of(0, 10, Sort.by("K1").descending());
        return charRepository.rankCharData();
    }
}
