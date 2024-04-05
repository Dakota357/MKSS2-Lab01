package com.hsbremen.mkss.lab.common.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="Compound")
@AllArgsConstructor
@NoArgsConstructor
public class Compound {
    @Id
    private String name;
    private int size;
    @OneToMany
    private List<Animal> animalList;
}
