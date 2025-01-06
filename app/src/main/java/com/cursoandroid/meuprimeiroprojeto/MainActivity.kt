package com.cursoandroid.meuprimeiroprojeto

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.cursoandroid.meuprimeiroprojeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this

        mainViewModel.text.value = "Aplicativo de Sorteio"

        binding.btnSend.setOnClickListener {
            val newText = binding.editTextName.text.toString()
            mainViewModel.updateText(newText)
            mainViewModel.randomNumberGenerator()

            binding.textView.visibility = android.view.View.VISIBLE

            binding.editTextName.text.clear()
        }
    }
}
