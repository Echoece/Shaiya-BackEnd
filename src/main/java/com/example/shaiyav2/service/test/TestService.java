package com.example.shaiyav2.service.test;

import com.example.shaiyav2.entity.UsersMaster;
import com.example.shaiyav2.entity.gamedefs.Items;
import com.example.shaiyav2.repository.TestRepository;
import com.example.shaiyav2.repository.gamedata.CharRepository;
import com.example.shaiyav2.entity.gamedata.RankCharData;
import com.example.shaiyav2.repository.gamedefs.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements TestServiceInterface{

    private final TestRepository testRepository;
    private final CharRepository charRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public TestService(TestRepository testRepository,ItemRepository itemRepository,CharRepository charRepository ){
        this.testRepository = testRepository;
        this.itemRepository=itemRepository;
        this.charRepository=charRepository;
    }

    public List<Items> findAll(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("itemName").descending());
        return itemRepository.test(pageable);
    }

    public List<RankCharData> allChars(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("charName").ascending());
        //return charRepository.test(pageable);
        return charRepository.rankCharData();
    }

    public UsersMaster getUserbyJwt(String Username){
        return testRepository.userByJwt(Username);
    }

}
