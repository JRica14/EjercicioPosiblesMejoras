package com.example.ejercicio9pantallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio9pantallaresumen.databinding.ActivityLoginBinding
import com.example.ejercicio9pantallaresumen.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.editTextEmail.text.isNotEmpty() && binding.editTextPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.editTextEmail.text.toString(),binding.editTextPassword.text.toString()).addOnCompleteListener(){
                    if (it.isSuccessful){
                        val intent= Intent(this, login::class.java)
                        startActivity(intent)
                    }else {
                        Toast.makeText(this, "Error al registrase", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}