package com.BankApplication.bank.Entity;

import jakarta.persistence.*;
import lombok.*;


//Structure of Database Table (Account)

//Account Entity represents a bank account with properties like ID, account holder name, and balance.
//It uses JPA annotations to define the entity and its mapping to the database.

//Creating Table with the entity class From SpringBoot frameWork

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="Account")
public class Account
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "AccountHolderName")
    private String AccountHolderName;

    @Column(name = "Balance")
    private double Balance;
}
