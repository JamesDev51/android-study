package com.team8.recyclerviewexample

enum class EGender{
    MALE, FEMALE, LGBT
}

data class Student (val name:String,
                                val id:String,
                                val gender:EGender,
                                val attend: Int,
                                val absence: Int){
}