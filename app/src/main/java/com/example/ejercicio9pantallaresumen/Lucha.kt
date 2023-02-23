package com.example.ejercicio9pantallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ejercicio9pantallaresumen.databinding.ActivityLuchaBinding
import java.io.IOException
import kotlin.random.Random

class Lucha : AppCompatActivity() {
    lateinit var binding: ActivityLuchaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLuchaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var personaje1= intent.getSerializableExtra("objeto") as Personaje

        if (intent.getIntExtra("play",15)==1){
            binding.pausar.visibility=View.VISIBLE
            binding.play.visibility=View.INVISIBLE
        }

        binding.play.setOnClickListener {
            mediaplayer!!.start()
            binding.pausar.visibility = View.VISIBLE
            binding.play.visibility = View.INVISIBLE
        }
        binding.pausar.setOnClickListener {
            mediaplayer!!.pause()
            binding.play.visibility = View.VISIBLE
            binding.pausar.visibility = View.INVISIBLE
        }
        binding.volver.setOnClickListener {
            try {
                mediaplayer!!.stop()
                mediaplayer!!.prepare()
                mediaplayer!!.seekTo(0)
                mediaplayer!!.start()
                binding.pausar.visibility = View.VISIBLE
                binding.play.visibility = View.INVISIBLE
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        var dado= Random.nextInt(1, 3)
        var enemigo= EnemigoPelea(100,20);
        when(dado) {
            1 -> enemigo= EnemigoPelea(200,30)
        }


        binding.progressBar.max=enemigo.vida
        binding.progressBar2.max=personaje1.vida
        binding.progressBar.progress=enemigo.vida
        binding.progressBar2.progress=personaje1.vida
        binding.luchar.setOnClickListener {

            var dado= Random.nextInt(1, 7)
            if (dado==4||dado==5 || dado==6) {
                println(personaje1.fuerza)
                println(enemigo.vida)
                enemigo.vida-=personaje1.fuerza
                binding.progressBar.progress=enemigo.vida
            }

            personaje1.vida-=enemigo.ataque
            binding.progressBar2.progress=personaje1.vida


            if (personaje1.vida<=0){
                intent = Intent(this, Blanco::class.java)
                startActivity(intent)
            }

            if (enemigo.vida<=0){
                intent = Intent(this, Empezar::class.java)
                intent.putExtra("objeto", personaje1)
                if (!binding.play.isVisible)
                    intent.putExtra("play", 1)
                else
                    intent.putExtra("play", 0)
                startActivity(intent)
            }
        }

        binding.huir.setOnClickListener {

            var dado= Random.nextInt(1, 7)

            if (dado==5 || dado==6) {
                intent = Intent(this, Empezar::class.java)
                intent.putExtra("objeto", personaje1)
                if (!binding.play.isVisible)
                    intent.putExtra("play", 1)
                else
                    intent.putExtra("play", 0)
                Toast.makeText(this,"Has podido huir", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else
                Toast.makeText(this,"No has podido huir", Toast.LENGTH_SHORT).show()

            personaje1.vida-=enemigo.ataque
            binding.progressBar2.progress=personaje1.vida



            if (personaje1.vida<=0){
                intent = Intent(this, Blanco::class.java)
                startActivity(intent)
            }

            if (enemigo.vida<=0){
                intent = Intent(this, Empezar::class.java)
                Toast.makeText(this,"Has ganado", Toast.LENGTH_SHORT).show()
                intent.putExtra("objeto", personaje1)
                if (!binding.play.isVisible)
                    intent.putExtra("play", 1)
                else
                    intent.putExtra("play", 0)

                startActivity(intent)
            }
        }

        binding.objeto.setOnClickListener {
            if (personaje1.vida+20<100)
                personaje1.vida+=20
            binding.progressBar2.progress=personaje1.vida

        }




    }


}
