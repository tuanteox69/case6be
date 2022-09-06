package com.example.case6be.services;

import com.example.case6be.models.SpendingGoal;
import com.example.case6be.models.Wallet;

import java.util.List;

public interface IWalletService {
    Wallet getAll(Wallet wallet);
    Wallet save (Wallet wallet);
    Wallet finByiduser(int id);


}
