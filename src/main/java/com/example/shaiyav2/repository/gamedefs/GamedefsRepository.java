package com.example.shaiyav2.repository.gamedefs;


import com.example.shaiyav2.entity.gamedefs.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamedefsRepository extends JpaRepository<Items,Long> {

}
