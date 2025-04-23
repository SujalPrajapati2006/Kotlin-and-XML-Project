package com.example.demoproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity(), View.OnClickListener {

    lateinit var btn_add: Button
    lateinit var btn_sub: Button
    lateinit var btn_mul: Button
    lateinit var btn_div: Button
    lateinit var etA: EditText
    lateinit var etB: EditText
    lateinit var result_tv: TextView  // Make sure to use this name consistently

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add = findViewById(R.id.btn_add)
        btn_sub = findViewById(R.id.btn_sub)
        btn_mul = findViewById(R.id.btn_mul)
        btn_div = findViewById(R.id.btn_div)
        etA = findViewById(R.id.etA)
        etB = findViewById(R.id.etB)
        result_tv = findViewById(R.id.result_tv)

        // Attach click listeners to the buttons
        btn_add.setOnClickListener(this)
        btn_sub.setOnClickListener(this)
        btn_mul.setOnClickListener(this)
        btn_div.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // Make sure to handle invalid input (empty or non-numeric input)
        val a = etA.text.toString().toDoubleOrNull()
        val b = etB.text.toString().toDoubleOrNull()

        if (a == null || b == null) {
            result_tv.text = "Please enter valid numbers"
            return
        }

        var result = 0.0

        when (v?.id) {
            R.id.btn_add -> {
                result = a + b
            }
            R.id.btn_sub -> {
                result = a - b
            }
            R.id.btn_mul -> {
                result = a * b
            }
            R.id.btn_div -> {
                // Check for division by zero
                if (b == 0.0) {
                    result_tv.text = "Cannot divide by zero"
                    return
                }
                result = a / b
            }
        }

        result_tv.text = "Result is $result"  // Use result_tv here instead of resultTv
    }
}
