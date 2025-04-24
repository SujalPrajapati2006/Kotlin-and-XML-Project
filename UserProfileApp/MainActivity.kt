package com.kotlinproject.userformapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.*
import android.view.View
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
import com.kotlinproject.userformapp.ui.theme.UserFormAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName = findViewById<EditText>(R.id.editName)
        val editPass = findViewById<EditText>(R.id.editPass)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editDate = findViewById<EditText>(R.id.editDate)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val btn = findViewById<Button>(R.id.btn_submit)
        val res = findViewById<TextView>(R.id.res)
        var spinner = findViewById<Spinner>(R.id.dropdown)

        var course = arrayOf("B-TECH","BCA","M-TECH","MCA","BBA","MBA")
        var option = ""

        if(spinner != null){
             val adapter = ArrayAdapter(
                  this,
                 android.R.layout.simple_spinner_item,course
             )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
             AdapterView.OnItemSelectedListener{
                override  fun onItemSelected(
                 parent: AdapterView<*>,
                 view: View,position:Int,id:Long
                ){
                    option = course[position]
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
             }
            btn.setOnClickListener()
            {
                val t1 = editName.text.toString()
                val t2 = editPass.text.toString()
                val t3 = editEmail.text.toString()
                val t4 = editDate.text.toString()
                val t5 = editPhone.text.toString()

                if (t1.isEmpty() || t2.isEmpty() ||
                    t3.isEmpty() || t4.isEmpty() || t5.isEmpty()
                ) {
                    res.text = "Enter All The Values"
                } else {
                    res.text = " Entered Values are : \n " +
                            "Name : ${t1} \n" +
                            "Password : ${t2} \n" +
                            "Email : ${t3} \n" +
                            "Date : ${t4} \n" +
                            "Phone No. : ${t5} \n " +
                            "Course : ${option}"
                }
            }
        }
    }
}
