package com.ProcessoSeletivo.ProcessoSeletivo.service;

import com.ProcessoSeletivo.ProcessoSeletivo.domain.Transaction;
import com.ProcessoSeletivo.ProcessoSeletivo.repository.TransactionRepository;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class Transactionservice {

    @Autowired
    private TransactionRepository transactionRepository;


    public Transaction postTransaction(Transaction transaction){

        return transactionRepository.save(transaction);
    }




    public List<Transaction> getAllTransaction()
    {
        return transactionRepository.findAll();
    }

    public Transaction putTransaction(Transaction transaction)
    {
        Transaction transactionExiste = transactionRepository.findById(transaction.getId()).get();

        if(transactionExiste == null)
        {
          return null;
        }
        return transactionRepository.save(transaction);
    }
}
