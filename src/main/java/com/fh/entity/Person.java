package com.fh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SPRING_DATA_PERSON", schema = "zenglei", catalog = "")
@Data
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    @Temporal(value = TemporalType.DATE)
    private Date birth;

    @Column(name = "ADD_ID")
    private int addressId;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
}
