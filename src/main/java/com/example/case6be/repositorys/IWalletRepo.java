package com.example.case6be.repositorys;

import com.example.case6be.models.SpendingGoal;
import com.example.case6be.models.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IWalletRepo extends CrudRepository<Wallet,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM case6.wallet where user_id =:id")
    Wallet checknamebyid(int id);
}