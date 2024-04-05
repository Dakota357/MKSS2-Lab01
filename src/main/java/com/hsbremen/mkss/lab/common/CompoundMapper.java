package com.hsbremen.mkss.lab.common;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Compound;
import de.hsbremen.mkss.restservice.model.AnimalDto;
import de.hsbremen.mkss.restservice.model.CompoundDto;
import de.hsbremen.mkss.restservice.model.SpeciesDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompoundMapper {

    private AnimalMapper animalMapper;

    public CompoundDto mapToCompoundDto(Compound compound) {
        CompoundDto compoundDto = new CompoundDto(compound.getName(),new BigDecimal(compound.getSize()));
        List<AnimalDto> animals = new ArrayList<>();
        compound.getAnimalList().forEach(e -> {
            animals.add(animalMapper.mapToAnimalDto(e));
        });
        compoundDto.setAnimals(animals);
        return compoundDto;
    }

    public Compound mapToCompound(CompoundDto compoundDto) {
        List<Animal> animals = new ArrayList<>();
        compoundDto.getAnimals().forEach(e -> {
            animals.add(animalMapper.mapToAnimal(e));
        });
        return new Compound(compoundDto.getName(),compoundDto.getSize().intValue(), animals);
    }

}
