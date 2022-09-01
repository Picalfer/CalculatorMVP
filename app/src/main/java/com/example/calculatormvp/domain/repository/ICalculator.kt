package com.example.calculatormvp.domain.repository

import com.example.calculatormvp.data.datamodel.ExpressionDataModel
import io.reactivex.Flowable

interface ICalculator {

    fun evaluateExpression(expression: String): Flowable<ExpressionDataModel>

}