package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var internalId: String? = null,
    var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var password: String? = null,
    var phone: String? = null,
    /* User Status */
    var userStatus: Int? = null
) {

}

