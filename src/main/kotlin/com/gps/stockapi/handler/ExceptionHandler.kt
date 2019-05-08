package com.gps.stockapi.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import com.gps.stockapi.exception.*


@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [
        InvalidUserException::class,
        InvalidProductException::class
    ])
    fun handleBadRequestException() = ResponseEntity.status(HttpStatus.BAD_REQUEST).build<Any>()

    @ExceptionHandler(value = [
        ProductNotFoundException::class,
        UserNotFoundException::class,
        TransactionNotFoundException::class
    ])
    fun handleNotFoundException() = ResponseEntity.status(HttpStatus.NOT_FOUND).build<Any>()

}