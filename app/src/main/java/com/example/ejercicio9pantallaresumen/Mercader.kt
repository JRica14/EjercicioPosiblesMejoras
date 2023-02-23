package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.persistableBundleOf
import androidx.core.view.isVisible
import com.example.ejercicio9pantallaresumen.databinding.CiudadBinding
import com.example.ejercicio9pantallaresumen.databinding.MercaderBinding
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding
import java.io.IOException

class Mercader : AppCompatActivity() {
    lateinit var binding: MercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= MercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var personaje1= intent.getSerializableExtra("objeto") as Personaje


        binding.button2.setOnClickListener {
            intent = Intent(this, Empezar::class.java)
            if(!binding.play.isVisible)
                intent.putExtra("play",1)
            else
                intent.putExtra("play",0)
            intent.putExtra("objeto",personaje1 )
            startActivity(intent)
        }

        if (intent.getIntExtra("play",15)==1){
            binding.pausar.visibility=View.VISIBLE
            binding.play.visibility=View.INVISIBLE
        }

        binding.button.setOnClickListener {
            binding.editTextNumber.visibility=View.VISIBLE
            binding.button.visibility= View.INVISIBLE
            binding.button2.visibility= View.INVISIBLE
            binding.Comprar.visibility=View.VISIBLE
            binding.vender.visibility=View.VISIBLE
            binding.cancelar.visibility=View.VISIBLE
        }

        binding.cancelar.setOnClickListener {
            binding.imageView7.setImageResource(R.drawable.mercader)
            binding.editTextNumber.visibility=View.INVISIBLE
            binding.button.visibility= View.VISIBLE
            binding.button2.visibility= View.VISIBLE
            binding.Comprar.visibility=View.INVISIBLE
            binding.vender.visibility=View.INVISIBLE
            binding.cancelar.visibility=View.INVISIBLE
        }

        binding.vender.setOnClickListener {
            binding.imageView7.setImageResource(R.drawable.mochila)
            var mensaje =personaje1.venta(binding.editTextNumber.text.toString().toInt(),Articulo(1,20,5,125))
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()

        }

        binding.Comprar.setOnClickListener {
            binding.imageView7.setImageResource(R.drawable.objeto)
           repeat(binding.editTextNumber.text.toString().toInt()){
               personaje1.mochilaP.addArticulo(Articulo(1,20,5,125))
           }
            Toast.makeText(this,"Objetos añadidos", Toast.LENGTH_SHORT).show()
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