package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        List<Chocolate> listOfAllChocolates = chocolateService.getChocolates();
        return new ResponseEntity<>(listOfAllChocolates, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable int id){
        Chocolate chocolate = chocolateService.getChocolates().get(id);
        return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }

}
