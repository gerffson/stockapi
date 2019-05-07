package com.gps.stockapi.business

import com.gps.stockapi.model.Stock
import com.gps.stockapi.repository.StockRepository
import org.springframework.beans.factory.annotation.Autowired

class StockBusiness {

    @Autowired
    private lateinit var stockRepository: StockRepository

    fun getStocks() : List<Stock> {
        return stockRepository.findAll().toList()
    }


    fun saveStock(entity : Stock): Stock{
        return stockRepository.save(entity)
    }

}