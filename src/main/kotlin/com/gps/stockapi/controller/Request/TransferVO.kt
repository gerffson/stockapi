package com.gps.stockapi.controller.Request

data class TransferVO(
        val locationIdOrigin: Int,
        val locationIdDestiny: Int,
        val productId: Int,
        val quantity: Double
) {
}