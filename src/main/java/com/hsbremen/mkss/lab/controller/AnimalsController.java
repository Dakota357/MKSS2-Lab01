package com.hsbremen.mkss.lab.controller;

import com.hsbremen.mkss.lab.api.AnimalsApi;

import com.hsbremen.mkss.lab.model.AnimalDto;
import com.hsbremen.mkss.lab.model.SpeciesDto;
import com.hsbremen.mkss.lab.service.AnimalsService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalsController implements AnimalsApi {

    private AnimalsService animalsService;
    @Override
    public ResponseEntity<AnimalDto> getAnimalByName(String name) {
        AnimalDto animalDto = animalsService.getAnimalByName(name);
        if(animalDto!=null){
            return ResponseEntity.ok(animalDto);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<AnimalDto>> getAnimalsBySpecies(String species) {
            SpeciesDto speciesDto = null;
        try {
            speciesDto = SpeciesDto.fromValue(species);
        }
        catch (Exception e){

        }
        if(speciesDto != null){
            List<AnimalDto> animals = animalsService.getAnimalsBySpecies(speciesDto);
            if(animals!=null){
                return ResponseEntity.ok(animals);
            }else {
                return ResponseEntity.noContent().build();
            }
        } else return ResponseEntity.badRequest().build();
    }

}
