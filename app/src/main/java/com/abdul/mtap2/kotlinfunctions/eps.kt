package com.abdul.mtap2.kotlinfunctions

import android.util.Log

val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double {
    Log.i("findfix","value of x = "+ x)
    if (Math.abs(x - Math.cos(x)) < eps) x
    else findFixPoint(Math.cos(x))
    return  x
}

fun main() {
    findFixPoint(20.0)
}