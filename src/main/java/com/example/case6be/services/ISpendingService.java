package com.example.case6be.services;

import com.example.case6be.models.Spending;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISpendingService {
Page<Spending> getAll(Pageable pageable);
Spending save (Spending spending);
void  delete(int id);

}
