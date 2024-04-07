package com.hsbremen.mkss.lab.dataccess.configuration;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Compound;
import com.hsbremen.mkss.lab.common.model.Species;
import com.hsbremen.mkss.lab.dataccess.AnimalRepository;
import com.hsbremen.mkss.lab.dataccess.CompoundsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {
    private final AnimalRepository animalRepository;
    private final CompoundsRepository compoundsRepository;

    public DataInitializer(AnimalRepository animalRepository, CompoundsRepository compoundsRepository) {
        this.animalRepository = animalRepository;
        this.compoundsRepository = compoundsRepository;
    }

    @Bean
    public int createExampleData() {
        List<Animal> birds = new ArrayList<>();
        Animal animal1 = new Animal("Theadora",Species.BIRDS, 2);
        birds.add(animal1);
        Animal animal2 = new Animal("Trueman",Species.BIRDS, 4);
        birds.add(animal2);
        Animal animal3 = new Animal("Edeline",Species.BIRDS, 3);
        birds.add(animal3);
        Animal animal4 = new Animal("Jule",Species.BIRDS, 2);
        birds.add(animal4);
        Animal animal5 = new Animal("Alla",Species.BIRDS, 3);
        birds.add(animal5);
        animalRepository.saveAll(birds);
        Compound birdCompound = new Compound("birds",20,birds);
        compoundsRepository.save(birdCompound);

        List<Animal> mammals = new ArrayList<>();
        Animal animal6 = new Animal("Robin",Species.MAMMALS, 12);
        mammals.add(animal6);
        Animal animal7 = new Animal("Vasilis",Species.MAMMALS, 13);
        mammals.add(animal7);
        Animal animal8 = new Animal("Nanny",Species.MAMMALS, 11);
        mammals.add(animal8);
        Animal animal9 = new Animal("Leonore",Species.MAMMALS, 12);
        mammals.add(animal9);
        Animal animal10 = new Animal("Reginald",Species.MAMMALS, 15);
        mammals.add(animal10);
        Animal animal11 = new Animal("Dorthy",Species.MAMMALS, 9);
        mammals.add(animal11);
        Animal animal12 = new Animal("Wilfred",Species.MAMMALS, 7);
        mammals.add(animal12);
        Animal animal13 = new Animal("Arden",Species.MAMMALS, 7);
        mammals.add(animal13);
        Animal animal14 = new Animal("Lianne",Species.MAMMALS, 10);
        mammals.add(animal14);
        Compound mammalsCompound = new Compound("mammals",20,mammals);

        animalRepository.saveAll(mammals);
        compoundsRepository.save(mammalsCompound);
        List<Animal> reptiles = new ArrayList<>();
        Animal animal15 = new Animal("Arielle",Species.REPTILES, 3);
        reptiles.add(animal15);
        Animal animal16 = new Animal("Tedra",Species.REPTILES, 3);
        reptiles.add(animal16);
        Animal animal17 = new Animal("Bianka",Species.REPTILES, 4);
        reptiles.add(animal17);
        Animal animal18 = new Animal("Flinn", Species.REPTILES, 5);
        reptiles.add(animal18);
        Animal animal19 = new Animal("Ceil",Species.REPTILES, 5);
        reptiles.add(animal19);
        Animal animal20 = new Animal("Ardella",Species.REPTILES, 2);
        reptiles.add(animal20);
        Animal animal21 = new Animal("Hortense",Species.REPTILES, 1);
        reptiles.add(animal21);
        Animal animal22 = new Animal("Modestine",Species.REPTILES, 2);
        reptiles.add(animal22);
        Compound reptilesCompound = new Compound("reptiles",20,reptiles);

        animalRepository.saveAll(reptiles);
        compoundsRepository.save(reptilesCompound);
        List<Animal> amphibians = new ArrayList<>();
        Animal animal23 = new Animal("Lorens",Species.AMPHIBIANS, 2);
        amphibians.add(animal23);
        Animal animal24 = new Animal("Barbaraanne",Species.AMPHIBIANS, 1);
        amphibians.add(animal24);
        Animal animal25 = new Animal("Adino",Species.AMPHIBIANS, 3);
        amphibians.add(animal25);
        Animal animal26 = new Animal("Shermie",Species.AMPHIBIANS, 1);
        amphibians.add(animal26);
        Animal animal27 = new Animal("Ansell",Species.AMPHIBIANS, 3);
        amphibians.add(animal27);
        Animal animal28 = new Animal("Davidson",Species.AMPHIBIANS, 3);
        amphibians.add(animal28);
        Animal animal29 = new Animal("Madalyn",Species.AMPHIBIANS, 4);
        amphibians.add(animal29);
        Animal animal30 = new Animal("Karissa",Species.AMPHIBIANS, 2);
        amphibians.add(animal30);
        Compound amphibiansCompound = new Compound("amphibians",20,amphibians);

        animalRepository.saveAll(amphibians);
        compoundsRepository.save(amphibiansCompound);

        Animal animal31 = new Animal("UnitTest",Species.BIRDS,2);
        animalRepository.save(animal31);

        return 1;
    }
}
