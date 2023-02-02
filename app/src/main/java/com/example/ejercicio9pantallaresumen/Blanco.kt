package com.example.ejercicio9pantallaresumen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9pantallaresumen.databinding.PantallaresumenBinding

class Blanco : AppCompatActivity() {
    lateinit var binding: PantallaresumenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blanco)
    }
}