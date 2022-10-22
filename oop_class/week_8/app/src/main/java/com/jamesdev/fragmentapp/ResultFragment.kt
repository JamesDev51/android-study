package com.jamesdev.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamesdev.fragmentapp.databinding.FragmentResultBinding



class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding?= null

    private var result: Int = 0

    /**
     * 순서
     * 1. companion object 의 newInstance() -> 팩토리 패턴으로  ResultFragment 객체가 생성됨
     * ResultFragment 로 전환될 때 파라미터로 넘어온 result 를 Bundle 객체에 담아서 arguments 필드에서 관리함
     *
     * 2. onCreate()로 화면을 실제로 만들기 전에 사전 세팅을 함
     * arguemnts 가 존재한다면 (newInstance에서 초기화했음) ARG_PARAM1에 해당하는 변수를 빼서 ResultFragment의 필드인 result에 할당
     *
     * 3. onCreateView()로 실제 화면을 만듬
     * binding에 resultNum의 text에 ResultFragment의 필드인 result 값을 할당시킴
     *
     * 4. binding?.root를 돌려줘서 화면을 띄움
     * 해당 화면 자체는 main activity (= bidning의 root)에 의해 binding 되어 있어서 binding.root를 반환함
     */

    companion object {

        @JvmStatic
        fun newInstance(result:Int) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM4, result)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result=it.getInt(ARG_PARAM4,0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentResultBinding.inflate(inflater,container,false)
        binding?.resultNum?.text=result.toString()

        return binding?.root
    }


}