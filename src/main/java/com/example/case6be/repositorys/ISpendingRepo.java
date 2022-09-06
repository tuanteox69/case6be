package com.example.case6be.repositorys;

import com.example.case6be.models.Spending;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISpendingRepo extends PagingAndSortingRepository<Spending,Integer> {
}
