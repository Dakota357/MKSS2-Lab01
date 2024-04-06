package com.hsbremen.mkss.lab.common.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@Table(name="Animal")
@NoArgsConstructor
public class Animal{

    @Id
    private String name;
    private Species species;
    private int age;


}
