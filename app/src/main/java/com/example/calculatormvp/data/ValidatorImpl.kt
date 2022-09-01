package com.example.calculatormvp.data

import com.example.calculatormvp.domain.repository.IValidator
import kotlin.math.exp

object ValidatorImpl : IValidator{

    override fun validateExpression(expression: String): Boolean {
        if (invalidStart(expression)) return false
        if (invalidEnd(expression)) return false

        if (hasConcurrentOperators(expression)) return false
        if (hadConcurrentDecimals(expression)) return false

        return true
    }

    private fun hadConcurrentDecimals(expression: String): Boolean {
        expression.indices
            .forEach {
                if (it < expression.lastIndex) {
                    if (isConcurrentDecimal(expression[it], expression[it + 1])) {
                        return true
                    }
                }
            }
        return false
    }

    private fun isConcurrentDecimal(current: Char, next: Char): Boolean {
        if (isOperator(current) && isOperator(next)) {
            return true
        }
        return false
    }

    private fun isOperator(char: Char): Boolean {
        return when {
            char.toString() == "+" -> true
            char.toString() == "-" -> true
            char.toString() == "/" -> true
            char.toString() == "*" -> true
            else -> false
        }
    }

    private fun hasConcurrentOperators(expression: String): Boolean {
        expression.indices
            .forEach {
                if (it < expression.lastIndex) {
                    if (isConcurrentOperator(expression[it], expression[it + 1])) {
                        return true
                    }
                }
            }
        return false
    }

    private fun isConcurrentOperator(current: Char, next: Char): Boolean {
        if (isOperator(current) && isOperator(next)){
            return true
        }
        return false
    }

    private fun invalidEnd(expression: String): Boolean {
        when {
            expression.endsWith("+") -> return true
            expression.endsWith("-") -> return true
            expression.endsWith("*") -> return true
            expression.endsWith("/") -> return true
            expression.endsWith(".") -> return true
            else -> return false
        }
    }

    private fun invalidStart(expression: String): Boolean {
        when {
            expression.startsWith("+") -> return true
            expression.startsWith("-") -> return true
            expression.startsWith("*") -> return true
            expression.startsWith("/") -> return true
            expression.startsWith(".") -> return true
            else -> return false
        }
    }
}