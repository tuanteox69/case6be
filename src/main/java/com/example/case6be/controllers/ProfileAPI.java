package com.example.case6be.controllers;

import com.example.case6be.models.AppUser;
import com.example.case6be.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/profile")
public class ProfileAPI {
    @Autowired
    AppUserService appUserService;

    @GetMapping("/{id}")
    public AppUser showUser(@PathVariable long id){
        return appUserService.findById(id);
    }

    @PostMapping("/create")
    public AppUser Create(@RequestBody AppUser appUser){
        return appUserService.save(appUser);
    }
}
