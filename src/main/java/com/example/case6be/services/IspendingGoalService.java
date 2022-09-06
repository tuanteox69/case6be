package com.example.case6be.services;

import com.example.case6be.models.SpendingGoal;

import java.util.List;

public interface IspendingGoalService {
    Iterable<SpendingGoal> findAll();

    SpendingGoal findById(int id);


    List<SpendingGoal> finByiduser(int id);

    SpendingGoal save(SpendingGoal spendingGoal);

    void delete(int id);

    SpendingGoal findByName(String name);
}
