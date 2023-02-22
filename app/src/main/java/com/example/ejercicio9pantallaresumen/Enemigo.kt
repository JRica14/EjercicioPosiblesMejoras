package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.ejercicio9pantallaresumen.databinding.CiudadBinding
import com.example.ejercicio9pantallaresumen.databinding.EnemigoBinding
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding
import java.io.IOException

class Enemigo: AppCompatActivity()  {
    lateinit var binding: EnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= EnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var personaje1= intent.getSerializableExtra("objeto") as Personaje


        binding.button2.setOnClickListener {
            intent = Intent(this, Empezar::class.java)
            intent.putExtra("objeto",personaje1 )
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            startActivity(intent)
        }
        if (intent.getIntExtra("play",15)==1){
            binding.pausar.visibility=View.VISIBLE
            binding.play.visibility=View.INVISIBLE
        }
        binding.button.setOnClickListener {
            intent = Intent(this, Blanco::class.java)
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            startActivity(intent)
        }
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
    }
}