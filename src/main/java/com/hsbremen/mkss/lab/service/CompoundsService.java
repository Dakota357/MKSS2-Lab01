package com.hsbremen.mkss.lab.service;

import com.hsbremen.mkss.lab.common.CompoundMapper;
import com.hsbremen.mkss.lab.common.model.Compound;
import com.hsbremen.mkss.lab.dataccess.AnimalsDao;
import com.hsbremen.mkss.lab.dataccess.CompoundsDao;
import com.hsbremen.mkss.lab.model.CompoundDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompoundsService {

    private CompoundMapper compoundMapper;
    private CompoundsDao compoundsDao;
    private AnimalsDao animalsDao;
    private HateoasService hateoasService;

    public void addAnimalToCompound(String animalName, String compoundName) {
        compoundsDao.addAnimalToCompound(animalName,compoundName);
    }


    public List<CompoundDto> getAllCompounds() {
        List<Compound> buff = compoundsDao.getAllCompounds();
        List<CompoundDto> results = new ArrayList<>();
        buff.forEach(e-> {
            CompoundDto compoundDto = compoundMapper.mapToCompoundDto(e);
            hateoasService.addLinksToCompound(compoundDto);
            results.add(compoundDto);
        });
        return results;
    }


    public CompoundDto getCompoundByName(String name) {
       Compound compound = compoundsDao.getCompoundByName(name);
       if(compound != null){
           CompoundDto compoundDto = compoundMapper.mapToCompoundDto(compound);
           hateoasService.addLinksToCompound(compoundDto);
           return compoundDto;
       }
       else {
           return null;
       }
    }


    public void removeAnimalFromCompound(String animalName, String compoundName) {
        compoundsDao.removeAnimalFromCompound(animalName,compoundName);
    }



}
