package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> listOfAllEstates = estateService.getEstates();
        return new ResponseEntity<>(listOfAllEstates, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable int id){
        Estate estate = estateService.getEstates().get(id);
        return new ResponseEntity<>(estate, HttpStatus.OK);
    }


}
