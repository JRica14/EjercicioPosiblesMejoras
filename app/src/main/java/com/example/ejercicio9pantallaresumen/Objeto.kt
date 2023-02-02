package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9pantallaresumen.databinding.CiudadBinding
import com.example.ejercicio9pantallaresumen.databinding.ObjetoBinding
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding

class Objeto: AppCompatActivity()  {
    lateinit var binding: ObjetoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // var personaje=intent.getSerializableExtra("Objeto") as Personaje
        var personaje1= intent.getSerializableExtra("objeto") as Personaje



        binding.button2.setOnClickListener {
            intent = Intent(this, Empezar::class.java)
            intent.putExtra("objeto",personaje1 )
            startActivity(intent)
        }
        binding.button.setOnClickListener {
           val mensaje= personaje1.mochilaP.addArticulo(Articulo(20,5,10))
            //Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
            println(mensaje)
            println(personaje1.mochilaP.toString())
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
            intent = Intent(this, Empezar::class.java)
            intent.putExtra("objeto",personaje1 )
            startActivity(intent)
        }
    }
}