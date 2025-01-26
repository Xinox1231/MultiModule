package com.example.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val viewModel = (application as ProvideViewModel).viewModel()

        viewModel.load()
        viewModel.liveData.observe(this){
            binding.mainText.text = it
        }
    }
}