package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding
import android.app.Activity
import android.media.MediaPlayer
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import java.io.IOException


class PantallaResumen  : AppCompatActivity() {
    lateinit var binding: PantallaresumenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantallaresumen)
        binding = PantallaresumenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var personaje= Personaje()
        mediaplayer = MediaPlayer.create(this, R.raw.stranger)
        mediaplayer!!.isLooping=true

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

        var foto1= intent.getStringExtra("Clase")
        var foto2= intent.getStringExtra("Raza")
        binding.textView.text="Fuerza: "+personaje.fuerza+"\n Defensa: "+personaje.defensa+"\nTamaño mochila: "+personaje.pesoMochila+"\n Vida: "+personaje.vida+"\n Monedero: "+personaje.monedero

        if(foto1=="ladron")
            binding.imageView2.setImageResource(R.drawable.ladron)
        else if (foto1=="mago")
            binding.imageView2.setImageResource(R.drawable.mago)
        else if(foto1=="berserker")
            binding.imageView2.setImageResource(R.drawable.berserker)
        else if (foto1=="guerrero")
            binding.imageView2.setImageResource(R.drawable.guerrero)

        if(foto2=="elfo")
            binding.imageView3.setImageResource(R.drawable.elfo)
        else if (foto2=="enano")
            binding.imageView3.setImageResource(R.drawable.enano)
        else if(foto2=="goblin")
            binding.imageView3.setImageResource(R.drawable.goblin)
        else if (foto2=="humano")
            binding.imageView3.setImageResource(R.drawable.humano)



        binding.Volveraempezar.setOnClickListener(){
            mediaplayer!!.pause()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.Comenzaraventura.setOnClickListener(){
            val intent = Intent(this, Empezar::class.java)
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            personaje.nombre=binding.editTextTextPersonName.text.toString()
            intent.putExtra("objeto",personaje )
            startActivity(intent)
        }

    }

}