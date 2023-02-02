package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9pantallaresumen.databinding.CiudadBinding
import com.example.ejercicio9pantallaresumen.databinding.MercaderBinding
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding

class Mercader : AppCompatActivity() {
    lateinit var binding: MercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= MercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var personaje1= intent.getSerializableExtra("objeto") as Personaje

        binding.button2.setOnClickListener {
            intent = Intent(this, Empezar::class.java)
            intent.putExtra("objeto",personaje1 )
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            intent = Intent(this, Blanco::class.java)
            startActivity(intent)
        }
    }
}