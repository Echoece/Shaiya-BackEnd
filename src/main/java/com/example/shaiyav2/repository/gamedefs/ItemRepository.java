package com.example.shaiyav2.repository.gamedefs;

import com.example.shaiyav2.entity.gamedefs.Items;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Items,Long> {
    @Query(value = "select * from PS_GameDefs.dbo.Items",nativeQuery = true)
    List<Items> test (Pageable pageable);
}
