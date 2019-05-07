package com.gps.stockapi.business

import com.gps.stockapi.model.Product
import com.gps.stockapi.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired

class ProductBusiness {

    @Autowired
    private lateinit var productRepository: ProductRepository

    fun getProducts() : List<Product> {
        return productRepository.findAll().toList()
    }


    fun saveProduct(entity : Product): Product{
        return productRepository.save(entity)
    }

}