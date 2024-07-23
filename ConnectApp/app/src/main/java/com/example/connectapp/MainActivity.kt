package com.example.connectapp

import androidx.activity.enableEdgeToEdge

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val UserMessage: EditText = findViewById(R.id.UserMessage)
        val btnSendMsg: Button = findViewById(R.id.btnSendMsg)
        btnSendMsg.setOnClickListener {
            val message: String = UserMessage.text.toString()
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("key", message)
            startActivity(intent)

    }
}