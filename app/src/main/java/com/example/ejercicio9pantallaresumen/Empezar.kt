package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.ejercicio9pantallaresumen.databinding.EmpezarBinding
import java.io.IOException
import kotlin.random.Random


class Empezar  : AppCompatActivity() {
    lateinit var binding : EmpezarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= EmpezarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var personaje1=intent.getSerializableExtra("objeto") as Personaje

        binding.imageButton2.setOnClickListener(){
           var dado=Random.nextInt(1, 5)
            println(dado)
            var intent = Intent()
            when(dado) {
                1 -> intent = Intent(this, Objeto::class.java);
                2 -> intent = Intent(this, Ciudad::class.java)
                3 ->  intent = Intent(this, Mercader::class.java)
                4 -> intent = Intent(this, Enemigo::class.java)
            }
            intent.putExtra("objeto",personaje1 )
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            startActivity(intent)
        }
        println(intent.getIntExtra("play",15))
        if (intent.getIntExtra("play",15)==1){
            binding.pausar.visibility=View.VISIBLE
            binding.play.visibility=View.INVISIBLE
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
