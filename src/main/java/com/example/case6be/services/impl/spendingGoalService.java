package com.example.case6be.services.impl;

import com.example.case6be.models.SpendingGoal;
import com.example.case6be.repositorys.IspendingGoalRepo;
import com.example.case6be.services.IspendingGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class spendingGoalService implements IspendingGoalService {
    @Autowired
    IspendingGoalRepo ispendingGoalRepo;
    @Override
    public Iterable<SpendingGoal> findAll() {
        return ispendingGoalRepo.findAll();
    }

    @Override
    public SpendingGoal findById(int id) {
        return ispendingGoalRepo.findById(id);
    }

    @Override
    public List<SpendingGoal> finByiduser(int id) {
        return ispendingGoalRepo.checknamebyid(id);
    }

    @Override
    public SpendingGoal save(SpendingGoal spendingGoal) {
        return ispendingGoalRepo.save(spendingGoal);
    }

    @Override
    public void delete(int id) {
        ispendingGoalRepo.deleteById(id);
    }

    @Override
    public SpendingGoal findByName(String name) {
        return ispendingGoalRepo.findByName(name);
    }
}
