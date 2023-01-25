package com.example.ejercicio9pantallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9pantallaresumen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var foto1=""

        binding.Ladron.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.ladron)
            binding.Aceptar.isEnabled=true
            foto1="ladron"
        }
        binding.Mago.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.mago)
            binding.Aceptar.isEnabled=true
            foto1="mago"
        }
        binding.Berserker.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.berserker)
            binding.Aceptar.isEnabled=true
            foto1="berserker"
        }
        binding.Guerrero.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.guerrero)
            binding.Aceptar.isEnabled=true
            foto1="guerrero"
        }
        binding.Aceptar.setOnClickListener(){
            val intent = Intent(this, PaginaBlanco::class.java)
            intent.putExtra("Clase",foto1)
            startActivity(intent)
        }
    }
}