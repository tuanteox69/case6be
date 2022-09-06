package com.example.case6be.controllers;

import com.example.case6be.models.Spending;
import com.example.case6be.services.ISpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/spending")
public class SpendingAPI {
    @Autowired
    ISpendingService spendingService;
    @GetMapping
    public Page<Spending> getAll(@RequestParam(defaultValue = "0") int page){
        return spendingService.getAll(PageRequest.of(page,5));
    }
    @PostMapping
    public Spending save(@RequestBody Spending spending){
        return spendingService.save(spending);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        spendingService.delete(id);
    }

}
