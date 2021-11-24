package com.example.recetarioapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDesayunos = findViewById<ImageButton>(R.id.btnDesayunos)
        btnDesayunos.setOnClickListener{
            val intento1 = Intent(this, Recetas::class.java)
            intento1.putExtra("tipoReceta", 1)
            startActivity(intento1)
        }

        val btnComida = findViewById<ImageButton>(R.id.btnComidas)
        btnComida.setOnClickListener{
            val intento1 = Intent(this, Recetas::class.java)
            intento1.putExtra("tipoReceta", 2)
            startActivity(intento1)
        }

        val btnCena = findViewById<ImageButton>(R.id.btnCenas)
        btnCena.setOnClickListener{
            val intento1 = Intent(this, Recetas::class.java)
            intento1.putExtra("tipoReceta", 3)
            startActivity(intento1)
        }

        val btnPostre = findViewById<ImageButton>(R.id.btnPostres)
        btnPostre.setOnClickListener{
            val intento1 = Intent(this, Recetas::class.java)
            intento1.putExtra("tipoReceta", 4)
            startActivity(intento1)
        }

        val btnAgregar = findViewById<ImageButton>(R.id.btnAgregar)
        btnAgregar.setOnClickListener{
            val intento1 = Intent(this, AgregarReceta::class.java)
            startActivity(intento1)
        }

    }
}