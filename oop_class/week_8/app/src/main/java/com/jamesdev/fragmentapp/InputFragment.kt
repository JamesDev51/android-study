package com.jamesdev.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.jamesdev.fragmentapp.databinding.FragmentInputBinding



class InputFragment : Fragment() {

    private var binding: FragmentInputBinding?= null

    private var num1 : Int = 0
    private var num2 : Int = 0
    private var num3 : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //arguments 가 null 이 아니면 필드에 값 할당
        arguments?.let {
            num1 = it.getInt(ARG_PARAM1, 0)
            num2 = it.getInt(ARG_PARAM2, 0)
            num3 = it.getInt(ARG_PARAM3, 0)
        }
        println("[onCreate] num1: $num1 num2:$num2 num3: $num3")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentInputBinding.inflate(inflater,container,false)

        //view를 만들 때 초기값인 0은 할당
        binding?.editNum1?.setText(num1.toString())
        binding?.editNum2?.setText(num2.toString())
        binding?.editNum3?.setText(num3.toString())

        binding?.editNum1?.setOnKeyListener{view,i, keyEvent->
            onResult()
            false
        }
        binding?.editNum2?.setOnKeyListener{view,i, keyEvent->
            onResult()
            false
        }
        binding?.editNum3?.setOnKeyListener{view,i, keyEvent->
            onResult()
            false
        }

        return binding?.root
    }
    private fun onResult(){

        Bundle().let { bundle ->
            binding?.editNum1?.text.toString().toIntOrNull()?.let { number->bundle.putInt(ARG_PARAM1,number) }
            binding?.editNum2?.text.toString().toIntOrNull()?.let { number->bundle.putInt(ARG_PARAM2,number) }
            binding?.editNum3?.text.toString().toIntOrNull()?.let { number->bundle.putInt(ARG_PARAM3,number) }

            //입력이 있을 때마다 main activity에 등록해놓은 setFragmentResultListener로 bundle을 재설정함
            setFragmentResult("input",bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(num1:Int, num2:Int, num3:Int) =
            InputFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1,num1)
                    putInt(ARG_PARAM2,num2)
                    putInt(ARG_PARAM3,num3)
                }
            }
    }
}