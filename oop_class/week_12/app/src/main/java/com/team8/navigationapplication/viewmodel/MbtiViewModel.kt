package com.team8.navigationapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team8.navigationapplication.repository.MbtiRepository

const val UNCHECKED_MBTI = "ISNP"

class MbtiViewModel:ViewModel() {

    private val repository = MbtiRepository()

    private var _mbti= MutableLiveData<String>(UNCHECKED_MBTI) //내부에서 변경되는 데이터
    val mbti: LiveData<String> get() = _mbti //외부에 공개되는 데이터

    init{
        repository.observeMbti(_mbti)
    }

    private fun modifyMbti(index: Int, newValue: Char) {
        _mbti.value = _mbti.value?.let{
            val chArr = it.toCharArray()

            chArr[index] = newValue

            String(chArr)
        } ?: UNCHECKED_MBTI

        repository.postMbti(_mbti.value ?: UNCHECKED_MBTI)
    }

    val isE get()=  _mbti.value?.get(0) =='E'
    val isN get()=  _mbti.value?.get(1) =='N'
    val isF get() =  _mbti.value?.get(2) =='F'
    val isJ get()=  _mbti.value?.get(3) =='J'

    fun setE(checked: Boolean) {
        modifyMbti(0, if(checked) 'E' else 'I' )
    }
    fun setN(checked: Boolean) {
        modifyMbti(1, if(checked) 'N' else 'S' )
    }
    fun setF(checked: Boolean) {
        modifyMbti(2, if(checked) 'F' else 'T' )
    }
    fun setJ(checked: Boolean) {
        modifyMbti(3, if(checked) 'J' else 'P' )
    }

}