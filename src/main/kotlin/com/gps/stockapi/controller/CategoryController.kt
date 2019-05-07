package com.gps.stockapi.controller

import com.gps.stockapi.business.CategoryBusiness
import com.gps.stockapi.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CategoryController {

    @Autowired
    private lateinit var categoryBusiness: CategoryBusiness


    @GetMapping("/categories")
    fun getCategories() : ResponseEntity<List<Category>> {
        return  ResponseEntity(categoryBusiness.getCategories(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/category"], method = [(RequestMethod.POST)])
    fun createCategory(@RequestBody category : Category): ResponseEntity<Category> {
        val persistedCategory =  categoryBusiness.saveCategory(category)
        return ResponseEntity(persistedCategory, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/category"], method = [(RequestMethod.PUT)])
    fun modifyCategory(@RequestBody category : Category): ResponseEntity<Category> {
        val persistedCategory =  categoryBusiness.saveCategory(category)
        return ResponseEntity(persistedCategory, HttpStatus.OK)
    }

}