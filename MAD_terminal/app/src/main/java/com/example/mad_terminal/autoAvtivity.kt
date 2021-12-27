package com.example.mad_terminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.R
import com.android.volley.RequestQueue

class autoAvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Toast.makeText(this, "Hi this activity called by auto", Toast.LENGTH_LONG).show()
    }

}