package com.gpticam.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.gpticam.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
        if(binding.editPeso.text.toString().isNotEmpty() && binding.editAltura.text.toString().isNotEmpty()){
            val imc = calcular()
            startActivity(Intent(this, ResultActivity::class.java))
        } else {
            Toast.makeText(this, "Digite o peso e a altura.", Toast.LENGTH_LONG).show()
        }


        }

    }
    fun calcular(): Double{
        val peso = binding.editPeso.text.toString().replace(",",",").toDouble()
        val altura = binding.editAltura.text.toString().replace(",",",").toDouble()
        return peso / (altura + altura)
    }
}