package com.hsbremen.mkss.lab.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Animal {


    private String name;

    private Species species;
    private int age;


}
