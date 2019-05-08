package com.gps.stockapi.business

import com.gps.stockapi.model.Category
import com.gps.stockapi.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class CategoryBusiness(@Autowired private var categoryRepository: CategoryRepository) {

    fun getCategories() : List<Category> {
        return categoryRepository.findAll().toList()
    }


    fun saveCategory(category : Category): Category {
        return categoryRepository.save(category)
    }

}