package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9pantallaresumen.databinding.ActivityMainBinding
import com.example.ejercicio9pantallaresumen.databinding.PaginablancoBinding

class PaginaBlanco : AppCompatActivity() {
    lateinit var binding: PaginablancoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paginablanco)
        setContentView(R.layout.paginablanco)
        binding = PaginablancoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var foto1= intent.getStringExtra("Clase")
        var foto2=""

        binding.Elfo.setOnClickListener() {
            binding.imageView.setImageResource(R.drawable.elfo)
            binding.Aceptar.isEnabled = true
            foto2="elfo"
        }
        binding.Enano.setOnClickListener() {
            binding.imageView.setImageResource(R.drawable.enano)
            binding.Aceptar.isEnabled = true
            foto2="enano"
        }
        binding.Goblin.setOnClickListener() {
            binding.imageView.setImageResource(R.drawable.goblin)
            binding.Aceptar.isEnabled = true
            foto2="goblin"
        }
        binding.Humano.setOnClickListener() {
            binding.imageView.setImageResource(R.drawable.humano)
            binding.Aceptar.isEnabled = true
            foto2="humano"
        }
        binding.Aceptar.setOnClickListener() {
            val intent = Intent(this, PantallaResumen::class.java)
            intent.putExtra("Clase",foto1)
            intent.putExtra("Raza",foto2)
            startActivity(intent)
        }
    }
}