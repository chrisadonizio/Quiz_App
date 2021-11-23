package com.adonizio.honorsmobileapps.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adonizio.honorsmobileapps.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
    }
}