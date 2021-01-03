package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    /*
    If i am gonna use @OneToMany, i have to use List
    If i want bidirectional relationship btw Person and Address OneToMany from Person to Address
    Add @OneToMany(mappedBy="person") into Person, and @ManyToOne into Address
    (mappedBy = "person") --> Give the control to Address class.
    If i don't use mappedBy, hibernate will creat a 3rd table which is called joint table, which we do not prefer
    If i create 2 joint tables, that means there will be 2 foreign keys and i do not want that.
    */
    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

//    Case1: i do not need AddressRepository, just look DataGenerator for the other small code for this case
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id")
//    private List<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}