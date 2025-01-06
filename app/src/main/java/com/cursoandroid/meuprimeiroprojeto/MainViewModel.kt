package com.cursoandroid.meuprimeiroprojeto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    val text = MutableLiveData<String>()
    val randomNumber = MutableLiveData<String>()

    fun updateText(newText: String) {
        text.value = "Bem-vindo(a), $newText"
    }

    fun randomNumberGenerator(){
        val number = Random.nextInt(1,101)
        randomNumber.value = "Número sorteado: $number"
    }
}
