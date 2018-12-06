package com.example.logonrmlocal.calculafiles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.logonrmlocal.calculafiles.extensions.getDouble
import com.example.logonrmlocal.calculafiles.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice))
        etEthanolPrice.addTextChangedListener(DecimalTextWatcher(etEthanolPrice))

        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage))
        etEthanolAverage.addTextChangedListener(DecimalTextWatcher(etEthanolAverage))

        btCalculate.setOnClickListener{
            val proximaTela = Intent(this, ResultActivity::class.java)
            proximaTela.putExtra("GAS_PRICE", etGasPrice.getDouble())
            proximaTela.putExtra("ETHANOL_PRICE", etEthanolPrice.getDouble())
            proximaTela.putExtra("GAS_AVARAGE", etGasAverage.getDouble())
            proximaTela.putExtra("ETHANOL_PRICE", etGasPrice.getDouble())
            startActivity(proximaTela)
        }


    }
}
