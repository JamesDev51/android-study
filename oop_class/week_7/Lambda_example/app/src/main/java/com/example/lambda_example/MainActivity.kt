package com.example.lambda_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lambda_example.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

		fun makeRandomArray(): IntArray{
				var randomArray=intArrayOf(0,0,0,0)
				for(i in 0..3){
						randomArray[i]=Random.nextInt(0,99)
				}
				return randomArray
		}
		fun makeArrayString():String{
				var result= ""
				for(elem in arr) result+="$elem "
				return result
		}
		fun getSumOfArray():Int{
				var result=0
				for(elem in arr) result+=elem
				return result
		}
		fun getProductOfArray():Int{
				var result=1
				for(elem in arr) result*=elem
				return result
		}
		fun getMaxOfArray():Int{
				var result=Int.MIN_VALUE
				for(elem in arr) result=Math.max(result,elem)
				return result
		}

		private var arr=makeRandomArray()

		private lateinit var binding: ActivityMainBinding

		override fun onCreate(savedInstanceState: Bundle?) {
				super.onCreate(savedInstanceState)

				binding=ActivityMainBinding.inflate(layoutInflater) //xml 파일을 풀어서 객체화 시키기 (화면 초기화)


				binding.txtRandomNumberArray.text = Random.nextInt(0,100).toString()

				binding.btnGenerate.setOnClickListener{
						arr=makeRandomArray()
						binding.txtRandomNumberArray.text = makeArrayString()
				}

				binding.btnSum.setOnClickListener{
						binding.txtResult.text=getSumOfArray().toString()
				}
				binding.btnProduct.setOnClickListener{
						binding.txtResult.text=getProductOfArray().toString()
				}
				binding.btnMax.setOnClickListener{
						binding.txtResult.text=getMaxOfArray().toString()
				}

				setContentView(binding.root)

		}
}