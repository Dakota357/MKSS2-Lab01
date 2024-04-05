package com.hsbremen.mkss.lab.dataccess;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Species;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalsDao {

    private ArrayList<Animal> animals;

    public AnimalsDao(){
        animals = new ArrayList<>();
        animals.add(new Animal("Hans", Species.BIRDS,2));
        animals.add(new Animal("Fritz", Species.MAMMALS,14));
        animals.add(new Animal("Berta", Species.INSECTS,7));
        animals.add(new Animal("Hilde", Species.REPTILES,22));
    }

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }


    public List<Animal> getAnimalsBySpecies(Species species) {
        ArrayList<Animal> foundAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getSpecies().equals(species)) {
                foundAnimals.add(animal);
            }
        }
        return foundAnimals;
    }


}
