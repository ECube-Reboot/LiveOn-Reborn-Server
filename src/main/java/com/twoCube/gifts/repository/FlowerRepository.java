package com.twoCube.gifts.repository;

import com.twoCube.gifts.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
    @Query(value="SELECT *  FROM flower ORDER BY rand() LIMIT 1"
            ,nativeQuery=true)
    Flower findFlowerByRand();
}
