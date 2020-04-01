package com.bignerdranch.nyethack.extensions

fun String.frame(padding: Int = 2, formatChar: String = "*"): String{
    val greeting = "$this!"
    var middle = formatChar.padEnd(padding)
        .plus(greeting)
        .plus(formatChar.padStart(padding))
    var end = (middle.indices).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}