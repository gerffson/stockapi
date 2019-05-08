package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Employee (
        @Id
        @GeneratedValue
        var id: Int? = null,
        var internalId: String? = null,
        var name: String? = null,
        var email: String? = null,
        var jobTitle: String? = null,
        var department: String? = null,
        var phone: String? = null,
        var status: Int? = null
) {

}

