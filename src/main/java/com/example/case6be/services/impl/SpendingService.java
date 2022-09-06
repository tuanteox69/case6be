package com.example.case6be.services.impl;

import com.example.case6be.models.Spending;
import com.example.case6be.repositorys.ISpendingRepo;
import com.example.case6be.services.ISpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpendingService implements ISpendingService {
    @Autowired
    ISpendingRepo iSpendingRepo;

    @Override
    public Page<Spending> getAll(Pageable pageable) {
        return iSpendingRepo.findAll(pageable);
    }


    @Override
    public Spending save(Spending spending) {
        return iSpendingRepo.save(spending);
    }

    @Override
    public void delete(int id) {
        iSpendingRepo.deleteById(id);
    }
}
