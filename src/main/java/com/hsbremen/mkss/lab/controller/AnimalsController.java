package com.hsbremen.mkss.lab.controller;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Species;
import com.hsbremen.mkss.lab.service.AnimalsService;
import de.hsbremen.mkss.restservice.api.AnimalsApi;

import de.hsbremen.mkss.restservice.model.AnimalDto;
import de.hsbremen.mkss.restservice.model.SpeciesDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalsController implements AnimalsApi {

    private AnimalsService animalsService;
    @Override
    public ResponseEntity<AnimalDto> getAnimalByName(String name) {
        return ResponseEntity.ok(animalsService.getAnimalByName(name));
    }

    @Override
    public ResponseEntity<List<AnimalDto>> getAnimalsBySpecies(SpeciesDto species) {
        List<AnimalDto> animals = animalsService.getAnimalsBySpecies(species);
        animals.forEach(animal->{
        });
        return ResponseEntity.ok(animals);
    }

}
