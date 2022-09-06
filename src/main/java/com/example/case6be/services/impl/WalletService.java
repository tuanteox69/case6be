package com.example.case6be.services.impl;

import com.example.case6be.models.Wallet;
import com.example.case6be.repositorys.IWalletRepo;
import com.example.case6be.services.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService implements IWalletService {
    @Autowired
    IWalletRepo iWalletRepo;
    @Override
    public Wallet getAll(Wallet wallet) {
        return (Wallet) iWalletRepo.findAll();
    }

    @Override
    public Wallet save(Wallet wallet) {
        return iWalletRepo.save(wallet);
    }

    @Override
    public Wallet finByiduser(int id) {
        return iWalletRepo.checknamebyid(id);
    }
}
