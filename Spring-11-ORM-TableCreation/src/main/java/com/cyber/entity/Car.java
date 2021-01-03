package com.cyber.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*Whenever you add @Entity annotation in the class level, relational mapping is done,
the class will be created in the db as a class
@Entity --> Create a table in db with the class name
@Entity & @Table(name="...") --> Create a table with this name for this pojo.
Remember to change the table name in data2.sql if i use this annotation.
@Entity(name="...") --> Create a table with this name for this pojo

Then i need to add the primary_key by using @Id annotaion on the top of the variable
 */
@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {

    //    the variables will be created as columns in DB. In this case there are 3 columns; id, make, model
//    @Id annotation is used to define the primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;

    //Since id will will auto generated, i need 2 arg constructor when i create object for db.
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

}
