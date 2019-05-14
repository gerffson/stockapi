package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Product (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var name: String,
    var externalId: String? = null,
    var brand: String? = null,
    var model: String? = null,
    var dimension: String? = null,
    var photoUrls: Array<String>? = null,
    var productType: Product.ProductType? = null,
    var status: Product.Status? = null
) {

    enum class ProductType(var varue: Any){
        material("material"),
        individual("individual");
    }

    enum class Status(var varue: Any){
        available("available"),
        pending("pending"),
        sold("sold");
    }

}

