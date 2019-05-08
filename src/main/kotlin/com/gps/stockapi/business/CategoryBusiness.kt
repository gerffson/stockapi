package com.gps.stockapi.business

import com.gps.stockapi.model.Category
import com.gps.stockapi.repository.CategoryRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class CategoryBusiness(@Autowired private var categoryRepository: CategoryRepository) {

    fun getCategories(): List<Category> {
        logger.info { "Buscando lista de categorias"}
        return categoryRepository.findAll().toList()
    }

    fun saveCategory(category: Category): Category {
        logger.info { "Salvando categoria" }
        return categoryRepository.save(category)
    }

}