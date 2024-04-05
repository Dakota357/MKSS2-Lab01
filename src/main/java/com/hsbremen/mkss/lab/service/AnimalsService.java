package com.hsbremen.mkss.lab.service;

import com.hsbremen.mkss.lab.common.AnimalMapper;
import com.hsbremen.mkss.lab.dataccess.AnimalsDao;
import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Species;
import de.hsbremen.mkss.restservice.model.AnimalDto;
import de.hsbremen.mkss.restservice.model.SpeciesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalsService {
    private AnimalsDao animalsDao;
    private AnimalMapper animalMapper;
    public AnimalDto getAnimalByName(String name) {
        return animalMapper.mapToAnimalDto(animalsDao.getAnimalByName(name));
    }


    public List<AnimalDto> getAnimalsBySpecies(SpeciesDto speciesDto) {
        Species species = Species.valueOf(speciesDto.toString());
        List<AnimalDto> animalDtos = new ArrayList<>();
        animalsDao.getAnimalsBySpecies(species).forEach(e ->{
            animalDtos.add(animalMapper.mapToAnimalDto(e));
        });
        return animalDtos;
    }
}
