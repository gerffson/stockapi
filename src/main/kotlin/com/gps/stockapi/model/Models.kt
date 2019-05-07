package com.gps.stockapi.model

import java.time.LocalDate
import javax.persistence.*


@Entity
data class User(
        @Id @GeneratedValue
        val id: Int = 0,
        val name : String,
        val login: String,
        val password: String? = null,
        val createDate: LocalDate? = null,
        val active: Boolean = false
)

@Entity
data class Product(
        @Id @GeneratedValue
        val id: Int = 0,
        val description: String,
        val brand : String,
        val model : String,
        val dimension : String,
        val lastDate: LocalDate? = null,
        val lastUser: String? = null,
        val createDate: LocalDate? = null,
        val externalId: String? = null,
        val internalId: String? = null,
        val active: Boolean = false
)

@Entity
data class Company(
        @Id @GeneratedValue
        val id: Int = 0,
        val cnpj: String,
        val tradingName: String,
        val companyName: String? = null,
        val lastDate: LocalDate? = null,
        val lastUser: String? = null,
        val createDate: LocalDate? = null,
        @Enumerated(EnumType.STRING)
        val type : CompanyType,
        val active: Boolean = false
)

enum class CompanyType {
    SUPPLIER, TRANSPORTATION
}


@Entity
data class Transaction(
        @Id @GeneratedValue
        val id: Int = 0,
        val transactionType: TransactionType,
        val transactionDate: LocalDate? = null,
        val company: Company,
        val user: String? = null
)

@Entity
data class TransactionItens(
        @Id @GeneratedValue
        val id: Int = 0,
        val transaction: Transaction,
        val operationType: OperationType,
        val stock: Stock,
        val product: Product,
        val qtd: Long
)


@Entity
data class  OperationType (
        val id: Int = 0,
        val description: String

)


@Entity
data class  TransactionType (
        val id: Int = 0,
        val description: String

)


@Entity
data class Invoice(
        @Id @GeneratedValue
        val id: Int = 0,
        val invoiceType: InvoiceType,
        val serie: String,
        val number: String? = null,
        val totalValue: Long,
        val invoiceDate: LocalDate? = null
)


@Entity
data class InvoiceItens(
        @Id @GeneratedValue
        val id: Int = 0,
        val invoice: Invoice,
        val product: Product,
        val value: Long,
        val qtd: Long
)

@Entity
data class InvoiceType (
        val id: Int = 0,
        val description: String

)


@Entity
data class Location(
        @Id @GeneratedValue
        val id: Int = 0,
        val description: String
)


@Entity
data class Stock(
        @Id @GeneratedValue
        val id: Int = 0,
        val location : Location,
        val product: Product,
        val qtd: Long,
        val Tag : String? = null
)