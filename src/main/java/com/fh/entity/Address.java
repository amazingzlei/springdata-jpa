package com.fh.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "SPRING_DATA_ADDRESS")
public class Address {
    @Id
    @GeneratedValue
    private int id;

    private String address;
}
