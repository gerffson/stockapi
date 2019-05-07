package com.gps.stockapi.controller

import com.gps.stockapi.business.ProductBusiness
import com.gps.stockapi.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {
    
    @Autowired
    private lateinit var productBusiness: ProductBusiness


    @GetMapping("/products")
    fun getCategories() : ResponseEntity<List<Product>> {
        return  ResponseEntity(productBusiness.getProducts(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/product"], method = [(RequestMethod.POST)])
    fun createProduct(@RequestBody product : Product): ResponseEntity<Product> {
        val persistedProduct =  productBusiness.saveProduct(product)
        return ResponseEntity(persistedProduct, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/product"], method = [(RequestMethod.PUT)])
    fun modifyProduct(@RequestBody product : Product): ResponseEntity<Product> {
        val persistedProduct =  productBusiness.saveProduct(product)
        return ResponseEntity(persistedProduct, HttpStatus.OK)
    }
}