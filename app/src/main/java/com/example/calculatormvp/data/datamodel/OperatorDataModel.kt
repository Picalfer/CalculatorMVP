package com.example.calculatormvp.data.datamodel

data class OperatorDataModel(val operatorValue: String) {
    val evaluateFirst: Boolean = checkPriority(operatorValue)

    private fun checkPriority(operatorValue: String): Boolean {
        return when (operatorValue) {
            "*" -> true
            "/" -> true
            "+" -> true
            "-" -> true
            else -> throw IllegalArgumentException("Illegal OperatorDataModel.")
        }
    }
}
