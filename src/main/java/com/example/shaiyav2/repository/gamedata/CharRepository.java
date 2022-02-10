package com.example.shaiyav2.repository.gamedata;


import com.example.shaiyav2.entity.gamedata.Chars;
import com.example.shaiyav2.entity.gamedata.RankCharData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharRepository extends JpaRepository<Chars,Long> {

    // native query
    @Query(value = "select * from PS_GameData.dbo.Chars",nativeQuery = true)
    List<Chars> charData (Pageable pageable);


    // closed projection, to get char name only
    // @Query(value = "select * from PS_GameData.dbo.Chars where del<>1",nativeQuery = true)
    @Query(value = "select * from PS_GameData.dbo.Chars",nativeQuery = true)
    List<RankCharData> rankCharData();

}
