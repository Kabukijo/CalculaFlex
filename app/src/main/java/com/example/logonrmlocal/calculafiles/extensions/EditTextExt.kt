package com.example.logonrmlocal.calculafiles.extensions

import android.widget.EditText

fun EditText.getDouble() = this.text.toString().toDouble()