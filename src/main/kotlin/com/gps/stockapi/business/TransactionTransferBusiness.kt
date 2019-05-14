package com.gps.stockapi.business

import com.gps.stockapi.controller.Request.TransferVO
import com.gps.stockapi.model.Stock
import com.gps.stockapi.model.Transaction
import com.gps.stockapi.model.TransactionTransfer
import com.gps.stockapi.repository.TransactionRepository
import com.gps.stockapi.repository.TransactionTransferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TransactionTransferBusiness (@Autowired private var transactionRepository: TransactionRepository,
                                   @Autowired private var transactionTransferRepository: TransactionTransferRepository,
                                   @Autowired private var stockBusiness: StockBusiness) {

    @Transactional
    fun transferBetweenStocks(transfer : TransferVO) : Transaction {
        stockBusiness.transferBetweenStocks(transfer.locationIdOrigin, transfer.locationIdDestiny, transfer.productId, transfer.quantity)
        val transaction  = createTransferTransaction()
        val stockOrigin  = stockBusiness.getByLocationIdAndProductId(transfer.locationIdOrigin,transfer.productId)
        val stockDestiny = stockBusiness.getByLocationIdAndProductId(transfer.locationIdDestiny,transfer.productId)
        transfer(transaction.id, stockOrigin.get(), transfer.quantity, TransactionTransfer.TransactionTransferType.OUT)
        transfer(transaction.id, stockDestiny.get(), transfer.quantity, TransactionTransfer.TransactionTransferType.IN)

        return transaction
    }


    private fun createTransferTransaction(): Transaction {
        return transactionRepository.save(Transaction(transactionType = Transaction.TransactionType.transfer))
    }

    private fun transfer(transactionId: Int?, stock: Stock, quantity: Double, type : TransactionTransfer.TransactionTransferType) {
        val transactionTransfer = TransactionTransfer(
                transactionId = transactionId,
                stockId = stock.id,
                quantity = quantity,
                transactionTransferType = type
        )
        transactionTransferRepository.save(transactionTransfer)
    }
}