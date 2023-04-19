package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long> {

    List<Chocolate> findAll();
}
