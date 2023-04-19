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
                "Hacienda San Jose",
                "Hacienda Limon",
                "Hacienda Victoria",
                "Hacienda La Victoria",
                "Hacienda La Chola",
                "Hacienda Monte Alto",
                "Hacienda El Castillo",
                "Hacienda Rio Verde",
                "Hacienda La Victoria",
                "Hacienda San Nicolas"
        );
        List<String> rawStLuciaEstates = Arrays.asList(
                "The Rabot Estate",
                "Marquis Estate",
                "Anse Mamin Plantation",
                "Emerald Estate",
                "Morne Coubaril Estate",
                "La Dauphine Estate"
        );
        List<String> rawGrenadaEstates = Arrays.asList(
                "Belmont Estate",
                "Crayfish Bay Organic Cocoa Estates"
        );

        for (String rawEstate : rawEcuadorEstates) {
            Estate estate = new Estate(rawEstate, "Ecuador");
            estateRepository.save(estate);
        }
        for (String rawEstate : rawStLuciaEstates) {
            Estate estate = new Estate(rawEstate, "St Lucia");
            estateRepository.save(estate);
        }
        for (String rawEstate : rawGrenadaEstates) {
            Estate estate = new Estate(rawEstate, "Grenada");
            estateRepository.save(estate);
        }


//          CHOCOLATES
        List<String> rawChocolates = Arrays.asList(
                "Dark Milk Original",
                "Dark Milk Hazelnut ",
                "Dark Milk Orange",
                "Dark Salted Caramel",
                "Dark Original",
                "Milk Original",
                "Milk Caramel",
                "Milk Fruit and Nut",
                "Ruby",
                "White"
        );

//      random estates and percentages of cocoa for when generating chocolates
        Random random = new Random();

        Long numberOfEstates = estateRepository.count();
        Long randomEstateIndex;

        int randomPercentageOfCocoa = 0;

//      generating chocolates
        for (String rawChocolate : rawChocolates) {
            randomEstateIndex = random.nextLong(numberOfEstates);
            if(rawChocolate.toLowerCase().contains("dark milk")) {
                randomPercentageOfCocoa = random.nextInt(55, 70);
            } else if (rawChocolate.toLowerCase().contains("dark")) {
                randomPercentageOfCocoa = random.nextInt(70, 90);
            } else if (rawChocolate.toLowerCase().contains("milk") || rawChocolate.toLowerCase().contains("ruby")) {
                randomPercentageOfCocoa = random.nextInt(35, 55);
            } else {
                randomPercentageOfCocoa = 0;
            }
            Chocolate chocolate = new Chocolate(rawChocolate, randomPercentageOfCocoa, estateRepository.findById(randomEstateIndex).get());
            chocolateRepository.save(chocolate);
        }


    }

}
