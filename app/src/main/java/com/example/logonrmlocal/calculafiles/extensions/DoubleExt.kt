package com.example.logonrmlocal.calculafiles.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)