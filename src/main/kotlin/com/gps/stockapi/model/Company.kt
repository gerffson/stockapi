package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Company (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var cnpj: String,
    var tradingName: String? = null,
    var companyName: String? = null,
    var companyType: Company.CompanyType? = null
) {

   enum class CompanyType(var varue: Any){
        suppiler("suppiler"),
        transportation("transportation");
    }

}

