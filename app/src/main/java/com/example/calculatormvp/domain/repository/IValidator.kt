package com.example.calculatormvp.domain.repository

interface IValidator {

    fun validateExpression(expression: String): Boolean

}