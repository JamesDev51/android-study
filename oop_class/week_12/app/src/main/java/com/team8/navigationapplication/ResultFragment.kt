package com.team8.navigationapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.team8.navigationapplication.databinding.FragmentResultBinding
import com.team8.navigationapplication.viewmodel.MbtiViewModel

class ResultFragment : Fragment() {

//    val viewModel: MbtiViewModel by viewModels() //fragment에 종속적
    val viewModel: MbtiViewModel by activityViewModels() //상위 activity에 종속적

    var binding: FragmentResultBinding ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mbti.observe(viewLifecycleOwner){
            binding?.txtResult?.text = viewModel.mbti.value
        } // 처음봤거나 변경됐으면 내용을 반영
        binding?.btnReexamine?.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_examineFragment)
        }
    }
}