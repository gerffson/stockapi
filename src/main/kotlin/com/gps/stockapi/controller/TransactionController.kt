package com.gps.stockapi.controller

import com.gps.stockapi.business.TransactionAquisitionBusiness
import com.gps.stockapi.business.TransactionTransferBusiness
import com.gps.stockapi.controller.Request.AquisitionVO
import com.gps.stockapi.controller.Request.TransferVO
import com.gps.stockapi.model.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController {
    
    @Autowired
    private lateinit var transactionAquisitionBusiness: TransactionAquisitionBusiness

    @Autowired
    private lateinit var transactionTransferBusiness: TransactionTransferBusiness


    @RequestMapping(value = ["/aquisition"], method = [(RequestMethod.POST)])
    fun createTransferTransaction(@RequestBody aquisition : AquisitionVO): ResponseEntity<Transaction> {
        val persistedTransaction =  transactionAquisitionBusiness.aquisitionProductToStock(aquisition)
        return ResponseEntity(persistedTransaction, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/transfer"], method = [(RequestMethod.POST)])
    fun createTransferTransaction(@RequestBody transfer : TransferVO): ResponseEntity<Transaction> {
        val persistedTransaction =  transactionTransferBusiness.transferBetweenStocks(transfer)
        return ResponseEntity(persistedTransaction, HttpStatus.CREATED)
    }
}