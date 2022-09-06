package com.example.case6be.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long money;
    @ManyToOne
    private AppUser user;
}
