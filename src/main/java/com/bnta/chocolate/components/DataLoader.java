package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    ChocolateRepository chocolateRepository;
    @Autowired
    EstateRepository estateRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

//        ESTATES
        List<String> rawEcuadorEstates = Arrays.asList(
                "Ecuador estate 1",
                "Ecuador estate 2",
                "Ecuador estate 3",
                "Ecuador estate 4"
        );
        List<String> rawStLuciaEstates = Arrays.asList(
                "St Lucia estate 1",
                "St Lucia estate 2",
                "St Lucia estate 3",
                "St Lucia estate 4"
        );
        for (String rawEstate : rawEcuadorEstates) {
            Estate estate = new Estate(rawEstate, "Ecuador");
            estateRepository.save(estate);
        }
        for (String rawEstate : rawStLuciaEstates) {
            Estate estate = new Estate(rawEstate, "St Lucia");
            estateRepository.save(estate);
        }


//          CHOCOLATES
        List<String> rawChocolates = Arrays.asList(
                "chocolate type 1",
                "chocolate type 2",
                "chocolate type 3",
                "chocolate type 4"
        );

//      random estates and percentages of cocoa for when generating chocolates
        Random random = new Random();

        Long numberOfEstates = estateRepository.count();
        Long randomEstateIndex;

        int randomPercentageOfCocoa;

//      generating chocolates
        for (String rawChocolate : rawChocolates) {
            randomEstateIndex = random.nextLong(numberOfEstates);
            randomPercentageOfCocoa = random.nextInt(60, 90);
            Chocolate chocolate = new Chocolate(rawChocolate, randomPercentageOfCocoa, estateRepository.findById(randomEstateIndex).get());
            chocolateRepository.save(chocolate);
        }


    }

}
