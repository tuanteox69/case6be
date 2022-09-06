package com.example.case6be.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    private String email;
    private String name;
    private String aress;
    private int phone;
    private int age;
    private String img;

}
