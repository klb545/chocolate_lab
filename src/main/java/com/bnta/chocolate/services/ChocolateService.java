package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChocolateService {


    @Autowired
    ChocolateRepository chocolateRepository;

    private List<Chocolate> chocolateList;

    public ChocolateService(){

    }

    public List<Chocolate> getChocolates(){
        return chocolateRepository.findAll();
    }
}

