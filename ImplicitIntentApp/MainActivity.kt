package com.kotlinproject.intentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.CallLog
import android.provider.ContactsContract
import android.widget.*
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.urlText)
        val btn = findViewById<Button>(R.id.btnNavigate)
        val btn1 = findViewById<Button>(R.id.btnCamera)
        val btn2 = findViewById<Button>(R.id.call)
        val btn3 = findViewById<Button>(R.id.contact)
        val btn4 = findViewById<Button>(R.id.gallery)
        val btn5 = findViewById<Button>(R.id.dialler)

        btn.setOnClickListener {
            var url: String = et1.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        btn1.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(camera_intent)
        }

        btn2.setOnClickListener {
            val intentCallLog = Intent(Intent.ACTION_VIEW)
            intentCallLog.setType(CallLog.Calls.CONTENT_TYPE)
            startActivity(intentCallLog)
        }
        btn3.setOnClickListener {
            val contIntent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(contIntent)
        }
        btn4.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.type = "image/*"
            startActivity(intent)
        }
        btn5.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel: +919876456543"))
            startActivity(intent)
        }
    }
}
