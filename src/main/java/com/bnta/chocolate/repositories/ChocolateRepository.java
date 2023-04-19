package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long> {

    List<Chocolate> findAll();

//    @Query("SELECT cocoaPercentage FROM chocolates WHERE cocoaPercentage.level BETWEEN :start AND :end")
//    List<Chocolate> findByCocoaPercentageBetween(@Param("start") int start, @Param("end") int end);
}
