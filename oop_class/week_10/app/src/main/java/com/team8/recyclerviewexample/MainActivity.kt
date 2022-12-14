package com.team8.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.team8.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val students = arrayOf(
        Student("풍자", "2030125100", EGender.LGBT, 10,0),
        Student("홍길동", "2030125100", EGender.MALE, 9,1),
        Student("성춘향", "2030125100", EGender.FEMALE, 10,0),
        Student("이몽룡", "2030125100", EGender.MALE, 10,0),
        Student("이순신", "2030125100", EGender.MALE, 8,2),
        Student("이효리", "2030125100", EGender.FEMALE, 7,3),
        Student("성유리", "2030125100", EGender.FEMALE, 10,0),
        Student("아이유", "2030125100", EGender.FEMALE, 5,5),
        Student("조정석", "2030125100", EGender.MALE, 6,4),
        Student("한가인", "2030125100", EGender.FEMALE, 10,0),
        Student("이승철", "2030125100", EGender.MALE, 10,0)
    )

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recStudents.layoutManager = LinearLayoutManager(this)
        binding.recStudents.adapter= StudentsAdapter(students)
    }
}