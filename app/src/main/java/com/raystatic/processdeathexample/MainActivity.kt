package com.raystatic.processdeathexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.raystatic.processdeathexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<ItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            viewModel.increment()
        }

        binding.btnSubtract.setOnClickListener {
            viewModel.decrement()
        }

        viewModel.counter.observe(this) {
            binding.textCounter.text = "$it"
        }

    }
}