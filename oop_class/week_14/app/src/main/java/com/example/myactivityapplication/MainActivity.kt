package com.example.myactivityapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myactivityapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSecondActivity.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)

            startActivity(intent)
        }
    }
}