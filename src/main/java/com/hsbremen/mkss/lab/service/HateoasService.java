package com.hsbremen.mkss.lab.service;

import de.hsbremen.mkss.restservice.model.AnimalDto;
import de.hsbremen.mkss.restservice.model.CompoundDto;
import de.hsbremen.mkss.restservice.model.LinkDto;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class HateoasService {

    public void addLinksToCompound(CompoundDto compoundDto){
        LinkDto all = new LinkDto();
        all.setHref(URI.create("/compounds"));
        all.setRel("_allCompounds");
        all.setType("GET");
        compoundDto.addLinksItem(all);

        LinkDto self = new LinkDto();
        self.setHref(URI.create("/compounds/" + compoundDto.getName()));
        self.setRel("_self");
        self.setType("GET");
        compoundDto.addLinksItem(self);

        compoundDto.getAnimals().forEach(e-> addLinksToAnimal(e,compoundDto));
    }

    public void addLinksToAnimal(AnimalDto animalDto, CompoundDto compoundDto){
        LinkDto all = new LinkDto();
        all.setHref(URI.create("/animals"));
        all.setRel("_all");
        all.setType("GET");
        animalDto.addLinksItem(all);

        LinkDto self = new LinkDto();
        self.setHref(URI.create("/animals/" + animalDto.getName()));
        self.setRel("_self");
        self.setType("GET");
        animalDto.addLinksItem(self);

        LinkDto species = new LinkDto();
        species.setHref(URI.create("/animals/species/" + animalDto.getSpecies()));
        species.setRel("_allOfSameSpecies");
        species.setType("GET");
        animalDto.addLinksItem(species);

        if(compoundDto!= null){
            LinkDto delete = new LinkDto();
            delete.setHref(URI.create("/compounds/" +compoundDto.getName() + "/animals/" + animalDto.getName()));
            delete.setRel("_removeFromCompound");
            delete.setType("DELETE");
            animalDto.addLinksItem(delete);
        }


    }
}