package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.calculate.text = "binging button"
        binding.calculate.setOnClickListener { calculate() }
    setContentView(binding.root)

  }

  fun calculate(){
    val cost = binding.cost.text.toString().toDouble()
    val selected = binding.percent.checkedRadioButtonId
    val percent = when(selected){
      binding.nice.id -> 0.2
      binding.well.id -> 0.1
      binding.bad.id -> 0.0
      else -> 0.0
    }
    //Toast.makeText(this,percent.toString(),Toast.LENGTH_SHORT).show()

    var money = (1-percent)*cost
    binding.totalCost.text = money.toString()
  }
}
