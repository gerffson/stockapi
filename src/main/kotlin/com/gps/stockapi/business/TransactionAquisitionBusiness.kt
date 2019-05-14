package com.gps.stockapi.business

import com.gps.stockapi.controller.Request.AquisitionVO
import com.gps.stockapi.model.Stock
import com.gps.stockapi.model.Transaction
import com.gps.stockapi.model.TransationAquisition
import com.gps.stockapi.repository.TransactionAquisitionRepository
import com.gps.stockapi.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TransactionAquisitionBusiness (@Autowired private var transactionRepository: TransactionRepository,
                                     @Autowired private var transationAquisitionRepository : TransactionAquisitionRepository,
                                     @Autowired private var stockBusiness: StockBusiness) {

    @Transactional
    fun aquisitionProductToStock(aquisition : AquisitionVO) : Transaction {
        stockBusiness.addProductToStock(aquisition.locationId,aquisition.productId,aquisition.quantity)
        val stock = stockBusiness.getByLocationIdAndProductId(aquisition.locationId,aquisition.productId)
        val transaction  = createAquisitionTransaction()
        aquisition(transaction.id, stock.get() , aquisition.quantity)
        return transaction
    }

    private fun createAquisitionTransaction(): Transaction {
        return transactionRepository.save(Transaction(transactionType = Transaction.TransactionType.invoice))
    }

    private fun aquisition(transactionId: Int?, stock: Stock, quantity: Double) {
        val transationAquisition = TransationAquisition(
                transactionId = transactionId,
                stockId = stock.id,
                quantity = quantity
        )
        transationAquisitionRepository.save(transationAquisition)
    }

}