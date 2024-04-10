package com.hsbremen.mkss.lab.service;

import com.hsbremen.mkss.lab.model.AnimalDto;
import com.hsbremen.mkss.lab.model.CompoundDto;
import com.hsbremen.mkss.lab.model.LinkDto;
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

    }
}
