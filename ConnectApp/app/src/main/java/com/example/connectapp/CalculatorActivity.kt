package com.example.connectapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calc)
        var inputnum1: EditText = findViewById(R.id.inputnum1)
        var inputnum2: EditText = findViewById(R.id.inputnum2)
        var spinner: Spinner = findViewById(R.id.spinner)
        var calcbtn: Button = findViewById(R.id.calcbtn)
        var result: TextView = findViewById(R.id.result)

        var options = arrayOf("addition","subtraction","multiplication","division")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options)

        var flag="addition"
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?){

            }
        }

        calcbtn.setOnClickListener{
            var x = inputnum1.text.toString().toDouble()
            var y = inputnum2.text.toString().toDouble()
            var out=0.0

            when(flag){
                "addition" -> {

                    out = x+y
                    result.text = "Result: " + out.toString()

                }
                "subtraction" -> {

                    out = x-y
                    result.text = "Result: " + out.toString()

                }
                "multiplication" -> {

                    out = x*y
                    result.text = "Result: " + out.toString()

                }
                else ->{

                    out = x/y
                    result.text = "Result: " + out.toString()

                }

            }
        }

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }


    }
}

    }
}