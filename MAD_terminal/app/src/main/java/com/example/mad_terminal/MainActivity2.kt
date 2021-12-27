package com.example.mad_terminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mad_terminal.ActivityBindingMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityBindingMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBindingMainBinding.inflate(layoutInflater)
        val view=binding.btn2
        setContentView(view)
        binding.textView.text="welcome"
        binding.button6.setOnClickListener({
            randomunction()
        })
    }

    private fun randomunction() {
        binding.textView.text=""
    }
}