package com.gps.stockapi.controller

import com.gps.stockapi.business.TransactionBusiness
import com.gps.stockapi.model.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TransactionController {
    
    @Autowired
    private lateinit var transactionBusiness: TransactionBusiness


    @GetMapping("/transactions")
    fun getCategories() : ResponseEntity<List<Transaction>> {
        return  ResponseEntity(transactionBusiness.getTransactions(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/transaction"], method = [(RequestMethod.POST)])
    fun createTransaction(@RequestBody transaction : Transaction): ResponseEntity<Transaction> {
        val persistedTransaction =  transactionBusiness.saveTransaction(transaction)
        return ResponseEntity(persistedTransaction, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/transaction"], method = [(RequestMethod.PUT)])
    fun modifyTransaction(@RequestBody transaction : Transaction): ResponseEntity<Transaction> {
        val persistedTransaction =  transactionBusiness.saveTransaction(transaction)
        return ResponseEntity(persistedTransaction, HttpStatus.OK)
    }
}