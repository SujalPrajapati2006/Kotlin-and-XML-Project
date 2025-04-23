package com.example.tipcalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tipcalculatorapp.ui.theme.TipCalculatorAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var billAmountInput : EditText
    private lateinit var tipGroup :  RadioGroup
    private lateinit var CalculateBtn : Button
    private lateinit var Result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

        billAmountInput = findViewById(R.id.et_bill)
        tipGroup = findViewById(R.id.tip_group)
        CalculateBtn = findViewById(R.id.btn_calculate)
         Result = findViewById(R.id.tv_result)

        CalculateBtn.setOnClickListener{
             val billAmount = billAmountInput.text.toString().toDoubleOrNull()
            if(billAmount == null){
                 Result.text = "Enter a Valid Amount "
                return@setOnClickListener
            }

            val tipPercent = when (tipGroup.checkedRadioButtonId){
                 R.id.tip_10 -> 0.10
                 R.id.tip_15 -> 0.15
                 R.id.tip_20 -> 0.20
                else -> 0.15
            }
            val tip = billAmount * tipPercent
            val total = billAmount + tip

            Result.text = "Tip: ₹%.2f\nTotal: ₹%.2f" . format(tip,total)
        }

    }
}

