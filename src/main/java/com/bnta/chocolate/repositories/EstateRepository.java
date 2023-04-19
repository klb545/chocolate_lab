package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {

    List<Estate> findAll();

}
