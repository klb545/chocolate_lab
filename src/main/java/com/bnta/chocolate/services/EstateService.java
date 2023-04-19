package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EstateService {

    @Autowired
    EstateRepository estateRepository;

    private List<Estate> estateList;

    public EstateService(){

    }

    public List<Estate> getEstates(){
        return estateRepository.findAll();
    }

    //    public Estate addNewEstate(Estate estate){
//        this.estateList.add(estate);
//        return estate;
//    }

}
