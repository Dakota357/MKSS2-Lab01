package com.hsbremen.mkss.lab.dataccess;

import com.hsbremen.mkss.lab.common.model.Animal;
import com.hsbremen.mkss.lab.common.model.Compound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompoundsRepository extends JpaRepository<Compound,String> {
    Compound findByAnimalListContaining(Animal animal);

}


