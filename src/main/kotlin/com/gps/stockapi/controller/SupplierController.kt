package com.gps.stockapi.controller

import com.gps.stockapi.model.Supplier
import com.gps.stockapi.repository.SupplierRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("stock")
class SupplierController{

    @Autowired
    private lateinit var supplierRepository: SupplierRepository

    @GetMapping("hello")
    fun getHello() : String{
        return "Hello World"
    }


    @GetMapping("/suppliers")
    fun getSuppliers() : ResponseEntity<List<Supplier>>{
        val listSuppliers = supplierRepository.findAll().toList();
        return ResponseEntity(listSuppliers,HttpStatus.OK)
    }


    @RequestMapping(value = ["/supplier"], method = [(RequestMethod.POST)])
    fun createSupplier(@RequestBody supplier : Supplier): ResponseEntity<Supplier> {
        val persistedSupplier=  supplierRepository.save(supplier)
        return ResponseEntity(persistedSupplier, HttpStatus.CREATED)
    }


}