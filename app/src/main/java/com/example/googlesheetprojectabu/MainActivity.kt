package com.example.googlesheetprojectabu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnRead: Button
    private lateinit var btnWrite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRead = findViewById(R.id.readfromDrive)
        btnWrite = findViewById(R.id.writeIntoDrive)

        btnRead.setOnClickListener {
            val intent = Intent(this, ActivityRead::class.java)
            startActivity(intent)
        }

        btnWrite.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

        // TODO: Implement functionality for btnWrite
    }
}
