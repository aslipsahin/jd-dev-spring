package com.cyber.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

//@MappedSuperclass annotation is used to create a super class and the super class is not created a table.
@MappedSuperclass
public class Account {

    @Id
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
