package com.cyber.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
//    here i do not need generated value since i am using data.sql, and there is id s there.
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
