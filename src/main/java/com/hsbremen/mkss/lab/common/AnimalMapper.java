package com.hsbremen.mkss.lab.common;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Species;
import de.hsbremen.mkss.restservice.model.AnimalDto;
import de.hsbremen.mkss.restservice.model.SpeciesDto;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {
    public AnimalDto mapToAnimalDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto(animal.getName(),animal.getAge());
        animalDto.setSpecies(SpeciesDto.fromValue(animal.getSpecies().toString().toLowerCase()));
        return animalDto;
    }

    public Animal mapToAnimal(AnimalDto animalDto) {
        return new Animal(animalDto.getName(), Species.valueOf(animalDto.getSpecies().toString().toLowerCase()),animalDto.getAge());
    }

}
