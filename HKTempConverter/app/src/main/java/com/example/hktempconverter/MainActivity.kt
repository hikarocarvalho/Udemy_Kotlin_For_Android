package com.example.hktempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var temp:EditText
    lateinit var celcius:RadioButton
    lateinit var farenheit:RadioButton
    lateinit var result:TextView
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get value
        temp = findViewById(R.id.temp) as EditText
        celcius = findViewById(R.id.radiocelsius) as RadioButton
        farenheit = findViewById(R.id.radiofarenheit) as RadioButton
        result = findViewById(R.id.result) as TextView
        button = findViewById(R.id.calculate) as Button
        button.setOnClickListener { convertTemp(it) }

    }
    fun convertTemp(view: View){
        var temperature: Double = temp.text.toString().toDouble()
        if(celcius.isChecked){
            temperature = (temperature - 32) / 1.8
            result.setText("Sua temperatura é de: " + temperature.toString() + "Em celsius")
        }else if(farenheit.isChecked){
            temperature = (temperature * 1.8) + 32
            result.setText("Sua temperatura é de: " + temperature.toString() + "Em Farenheit")
        }
        else{
            result.setText("Seleção ou valor errado! Digite novamente")
        }

    }
}
