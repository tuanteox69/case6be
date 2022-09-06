package com.example.case6be.controllers;

import com.example.case6be.models.SpendingGoal;
import com.example.case6be.models.Wallet;
import com.example.case6be.services.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/wallet")
public class WalletAPI {
    @Autowired
    IWalletService iWalletService;

    @GetMapping("/{id}")
    public Wallet findByIduser(@PathVariable int id){
        return iWalletService.finByiduser(id);
    }

    @PostMapping
    public Wallet save(@RequestBody Wallet wallet) {
        return iWalletService.save(wallet);
    }
}
