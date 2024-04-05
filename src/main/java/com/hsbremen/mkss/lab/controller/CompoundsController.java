package com.hsbremen.mkss.lab.controller;

import com.hsbremen.mkss.lab.service.CompoundsService;
import de.hsbremen.mkss.restservice.api.CompoundsApi;
import de.hsbremen.mkss.restservice.model.CompoundDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompoundsController implements CompoundsApi {

    private CompoundsService compoundsService;
    @Override
    public ResponseEntity<Void> addAnimalToCompound(String animalName, String compoundName) {
        compoundsService.addAnimalToCompound(animalName,compoundName);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<CompoundDto>> getAllCompounds() {
        return ResponseEntity.ok(compoundsService.getAllCompounds());
    }

    @Override
    public ResponseEntity<CompoundDto> getCompoundByName(String name) {
        return ResponseEntity.ok(compoundsService.getCompoundByName(name));
    }

    @Override
    public ResponseEntity<Void> removeAnimalFromCompound(String animalName, String compoundName) {
        compoundsService.removeAnimalFromCompound(animalName, compoundName);
        return ResponseEntity.noContent().build();
    }

}
