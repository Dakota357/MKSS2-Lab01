package com.hsbremen.mkss.lab.service;

import com.hsbremen.mkss.lab.common.CompoundMapper;
import com.hsbremen.mkss.lab.common.model.Compound;
import com.hsbremen.mkss.lab.dataccess.CompoundsDao;
import de.hsbremen.mkss.restservice.model.CompoundDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompoundsService {

    private CompoundMapper compoundMapper;
    private CompoundsDao compoundsDao;
    public void addAnimalToCompound(String animalName, String compoundName) {
        //TODO
    }


    public List<CompoundDto> getAllCompounds() {

        return null;
    }


    public CompoundDto getCompoundByName(String name) {
        return null;
    }


    public void removeAnimalFromCompound(String animalName, String compoundName) {
    }

}
