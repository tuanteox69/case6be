package com.example.case6be.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SpendingGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private AppUser user;


}
