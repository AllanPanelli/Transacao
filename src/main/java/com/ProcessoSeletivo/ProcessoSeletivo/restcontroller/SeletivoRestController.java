package com.ProcessoSeletivo.ProcessoSeletivo.restcontroller;

import com.ProcessoSeletivo.ProcessoSeletivo.domain.Transaction;
import com.ProcessoSeletivo.ProcessoSeletivo.service.Transactionservice;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeletivoRestController {

    @Autowired
    private Transactionservice transactionservice;



    @PostMapping("/transaction")
    public ResponseEntity<Transaction> postTransaction( @RequestBody Transaction transacao){

        Transaction transacaoPost = transactionservice.postTransaction(transacao);

        if(transacaoPost == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(transacaoPost, HttpStatus.CREATED);
    }

    @GetMapping("/transaction/all")
    public ResponseEntity<List<Transaction>> getTransaction(){

        List<Transaction> transacaoLista = transactionservice.getAllTransaction();

        if(transacaoLista.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(transacaoLista, HttpStatus.OK);
    }


    @PutMapping("/transaction")
    public ResponseEntity<Transaction> putTransaction(@RequestBody Transaction transaction) {
        Transaction transactionExiste = transactionservice.putTransaction(transaction);
        if(transactionExiste== null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactionExiste,HttpStatus.OK);

    }


}
