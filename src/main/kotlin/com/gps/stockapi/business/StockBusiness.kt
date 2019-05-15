package com.gps.stockapi.business

import com.gps.stockapi.exception.StockNotFoundException
import com.gps.stockapi.model.Stock
import com.gps.stockapi.repository.StockRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class StockBusiness(@Autowired private var stockRepository: StockRepository) {

    fun getStocks() : List<Stock> {
        return stockRepository.findAll().toList()
    }


    fun saveStock(entity : Stock): Stock{
        return stockRepository.save(entity)
    }


    fun getStockbyId(stockId : Int) : Optional<Stock> {
        return stockRepository.findById(stockId)
    }

    fun getByLocationIdAndProductId(locationId : Int,productId : Int) : Optional<Stock> {
        return stockRepository.findByLocationIdAndProductId(locationId,productId)
    }


    fun addProductToStock(locationId : Int, productId : Int, quantity : Double ) : Stock{
        val stock = stockRepository
                .findByLocationIdAndProductId(locationId,productId)
                .orElse(Stock(locationId,productId, 0.0))

        stock.quantity += quantity
        return stockRepository.save(stock)
    }


    fun transferBetweenStocks(locationIdOrigin : Int,locationIdDestiny : Int, productId : Int, quantity : Double ){

        val stockOrigin  = stockRepository
                .findByLocationIdAndProductId(locationIdOrigin,productId)
                .orElseThrow{ StockNotFoundException () }


        if(stockOrigin.quantity >= quantity){

            val stockDestiny = stockRepository
                    .findByLocationIdAndProductId(locationIdDestiny,productId)
                    .orElse(Stock(locationIdDestiny,productId, 0.0))

            stockOrigin.quantity -= quantity
            stockRepository.save(stockOrigin)

            stockDestiny.quantity += quantity
            stockRepository.save(stockDestiny)

        }
    }


    fun removeProductFromStock(locationId : Int, productId : Int, quantity : Double ){

        val stock = stockRepository
                .findByLocationIdAndProductId(locationId,productId)
                .orElseThrow{ StockNotFoundException () }

        stock.quantity -= quantity
        stockRepository.save(stock)
    }



}