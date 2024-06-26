package com.hsbremen.mkss.lab.dataccess;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Compound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CompoundsDao {

    private CompoundsRepository compoundsRepository;
    private AnimalRepository animalRepository;

    public void addAnimalToCompound(String animalName, String compoundName) {
        Optional<Compound> compound = compoundsRepository.findById(compoundName);
        Optional<Animal> animal = animalRepository.findById(animalName);
        if(animal.isPresent() && compound.isPresent()){
            Compound oldCompound = compoundsRepository.findByAnimalListContaining(animal.get());
            if(oldCompound != null){
                oldCompound.getAnimalList().remove(animal.get());
                compoundsRepository.save(oldCompound);
            }
            compound.get().getAnimalList().add(animal.get());
            compoundsRepository.save(compound.get());

        }
    }


    public List<Compound> getAllCompounds() {
        return compoundsRepository.findAll();
    }


    public Compound getCompoundByName(String name) {
        Optional<Compound> compound = compoundsRepository.findById(name);
        return compound.orElse(null);
    }


    public void removeAnimalFromCompound(String animalName, String compoundName) {
        Optional<Compound> compound = compoundsRepository.findById(compoundName);
        Optional<Animal> animal = animalRepository.findById(animalName);
        if(compound.isPresent() && animal.isPresent()){
            compound.get().getAnimalList().remove(animal.get());
            compoundsRepository.save(compound.get());
            //animalRepo.save?
        }
    }
}
