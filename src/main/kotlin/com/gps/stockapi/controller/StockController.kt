package com.gps.stockapi.controller

import com.gps.stockapi.business.StockBusiness
import com.gps.stockapi.model.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class StockController {

    @Autowired
    private lateinit var stockBusiness: StockBusiness


    @GetMapping("/stocks")
    fun getCategories() : ResponseEntity<List<Stock>> {
        return  ResponseEntity(stockBusiness.getStocks(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/stock"], method = [(RequestMethod.POST)])
    fun createStock(@RequestBody stock : Stock): ResponseEntity<Stock> {
        val persistedStock =  stockBusiness.saveStock(stock)
        return ResponseEntity(persistedStock, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/stock"], method = [(RequestMethod.PUT)])
    fun modifyStock(@RequestBody stock : Stock): ResponseEntity<Stock> {
        val persistedStock =  stockBusiness.saveStock(stock)
        return ResponseEntity(persistedStock, HttpStatus.OK)
    }
}