package com.example.ejercicio9pantallaresumen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9pantallaresumen.databinding.EmpezarBinding
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
            startActivity(intent)
        }
    }
}
