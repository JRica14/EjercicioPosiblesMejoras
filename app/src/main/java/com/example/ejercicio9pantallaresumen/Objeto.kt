package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.ejercicio9pantallaresumen.databinding.CiudadBinding
import com.example.ejercicio9pantallaresumen.databinding.ObjetoBinding
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding
import java.io.IOException

class Objeto: AppCompatActivity()  {
    lateinit var binding: ObjetoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // var personaje=intent.getSerializableExtra("Objeto") as Personaje
        var personaje1= intent.getSerializableExtra("objeto") as Personaje


        binding.play.setOnClickListener {
            mediaplayer!!.start()
            binding.pausar.visibility=View.VISIBLE
            binding.play.visibility=View.INVISIBLE
        }
        binding.pausar.setOnClickListener {
            mediaplayer!!.pause()
            binding.play.visibility=View.VISIBLE
            binding.pausar.visibility=View.INVISIBLE
        }
        binding.volver.setOnClickListener {
            try {
                mediaplayer!!.stop()
                mediaplayer!!.prepare()
                mediaplayer!!.seekTo(0)
                mediaplayer!!.start()
                binding.pausar.visibility=View.VISIBLE
                binding.play.visibility=View.INVISIBLE
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        if (intent.getIntExtra("play",15)==1){
            binding.pausar.visibility=View.VISIBLE
            binding.play.visibility=View.INVISIBLE
        }


        binding.button2.setOnClickListener {
            intent = Intent(this, Empezar::class.java)
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            intent.putExtra("objeto",personaje1 )
            startActivity(intent)
        }
        binding.button.setOnClickListener {
           val mensaje= personaje1.mochilaP.addArticulo(Articulo(1,20,5,125))
            //Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
            println(mensaje)
            println(personaje1.mochilaP.toString())
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
            intent = Intent(this, Empezar::class.java)
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            intent.putExtra("objeto",personaje1 )
            startActivity(intent)
        }


    }
}