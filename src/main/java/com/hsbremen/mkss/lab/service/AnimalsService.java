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
    private HateoasService hateoasService;

    public AnimalDto getAnimalByName(String name) {
        Animal result = animalsDao.getAnimalByName(name);
        if(result!=null){
            AnimalDto animalDto = animalMapper.mapToAnimalDto(result);
            hateoasService.addLinksToAnimal(animalDto,null);
            return animalDto;
        }
        else return null;
    }


    public List<AnimalDto> getAnimalsBySpecies(SpeciesDto speciesDto) {
        Species species = Species.valueOf(speciesDto.name());
        List<AnimalDto> animalDtos = new ArrayList<>();
        animalsDao.getAnimalsBySpecies(species).forEach(e ->{
            AnimalDto animalDto = animalMapper.mapToAnimalDto(e);
            hateoasService.addLinksToAnimal(animalDto,null);
            animalDtos.add(animalDto);
        });
        return animalDtos;
    }
}
