package com.example.myactivityapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
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

        binding.btnService.setOnClickListener {
            val intent = Intent(this, ProgressService::class.java)

//            startService(intent)
            ContextCompat.startForegroundService(this,intent)
        }

    }
}