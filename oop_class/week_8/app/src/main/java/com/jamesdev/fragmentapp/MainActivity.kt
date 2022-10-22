package com.jamesdev.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.jamesdev.fragmentapp.databinding.ActivityMainBinding

const val ARG_PARAM1 = "num1"
const val ARG_PARAM2 = "num2"
const val ARG_PARAM3 = "num3"
const val ARG_PARAM4 = "result"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var num1: Int=0
    private var num2: Int=0
    private var num3: Int=0

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().run {
            replace(binding.frmFragment.id,fragment)
            commit()
        }
    }



    private fun replaceInputFragment(){

        //다시 main -> input 으로 돌아갈 때 activity에 저장해놓은 값을 input 으로 넣어줌
        val inputFragment = InputFragment.newInstance(num1,num2,num3)

        //main activity의 frm_fragment에 input fragment 페이지로 갈아껴줌
        replaceFragment(inputFragment)

        //input fragment -> main activity 로 값을 넘겨줄 수 있도록 설정함 (주는곳 - input fragment, 받는곳 - main activity)
        inputFragment.setFragmentResultListener("input"){_,bundle->
            num1=bundle.getInt(ARG_PARAM1,0)
            num2=bundle.getInt(ARG_PARAM2,0)
            num3=bundle.getInt(ARG_PARAM3,0)
            println("[setFragmentResultListener] num1: $num1 num2:$num2 num3: $num3")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //처음 main activity를 시작할 때 input 창이 frm_fragment 에 뜨도록 함
        replaceInputFragment()

        //입력 버튼을 클릭하면 main activy의  frm_fragment에 input fragment로 갈아 껴지도록 설정
        binding.btnInput.setOnClickListener{
            replaceInputFragment()
        }

        //첫번째 버튼을 클릭하면 main activy의  frm_fragment에 result fragment로 갈아 껴지도록 설정
        binding.btnFirst.setOnClickListener {
            replaceFragment(ResultFragment.newInstance(num1))
        }

        //첫번째 버튼을 클릭하면 main activy의  frm_fragment에 result fragment로 갈아 껴지도록 설정
        binding.btnSecond.setOnClickListener {
            replaceFragment(ResultFragment.newInstance(num2))
        }

    }
}