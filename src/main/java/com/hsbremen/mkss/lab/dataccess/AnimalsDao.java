package com.hsbremen.mkss.lab.dataccess;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Species;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AnimalsDao {

    private AnimalRepository animalRepository;

    public Animal getAnimalByName(String name) {
        Optional<Animal> result =  animalRepository.findById(name);
        return result.orElse(null);
    }

    public List<Animal>getAllAnimals(){
        return animalRepository.findAll();
    }


    public List<Animal> getAnimalsBySpecies(Species species) {
        return animalRepository.findBySpecies(species);
    }

}
