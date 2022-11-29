package com.example.myactivityapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
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

        binding.btnWorker.setOnClickListener {
            val constraints = androidx.work.Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .setRequiresCharging(true)
                .build()
            val workRequest = OneTimeWorkRequest.Builder(CountWorker::class.java)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(applicationContext).enqueue(workRequest)

        }

    }
}