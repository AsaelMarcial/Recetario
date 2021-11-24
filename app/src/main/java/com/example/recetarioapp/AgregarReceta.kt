package com.example.recetarioapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.appejemplosqlite.AdminSQLite

class AgregarReceta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_receta)

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val descripcion = findViewById<EditText>(R.id.txtBoxDescripcion)
        val ingredientes = findViewById<EditText>(R.id.txtBoxIngredientes)
        val preparacion = findViewById<EditText>(R.id.txtPreparacion)
        val url = findViewById<EditText>(R.id.txtUrl)
        var tipo = 1;

        val spinner = findViewById<Spinner>(R.id.spinner)

        val lista = arrayOf("Desayuno", "Comida", "Cena", "Postre")

        val adaptador = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista)
        spinner.adapter = adaptador
        val btnAgregar = findViewById<Button>(R.id.btnAgregarReceta)

        btnAgregar.setOnClickListener {
            when (spinner.selectedItem.toString()){
                "Desayuno"-> tipo = 1
                "Comida"-> tipo = 2
                "Cena" -> tipo = 3
                "Postre" -> tipo = 4
            }
            val receta = AdminSQLite(this,"receta",null,1)
            val bd = receta.writableDatabase
            val registro = ContentValues()
            registro.put("tipo",tipo)
            registro.put("nombre",nombre.getText().toString())
            registro.put("descripcion",descripcion.getText().toString())
            registro.put("ingredientes",ingredientes.getText().toString())
            registro.put("preparacion",preparacion.getText().toString())
            registro.put("video",url.getText().toString())

            if(nombre.getText().isEmpty() ||descripcion.getText().isEmpty() || ingredientes.getText().isEmpty() || preparacion.getText().isEmpty() || url.getText().isEmpty()){
                Toast.makeText(this, "Verificar campos vacios!.", Toast.LENGTH_LONG).show()
            }else{
                bd.insert("receta", null,registro)
                bd.close()
                Toast.makeText(this, "Se registraron los articulos.", Toast.LENGTH_LONG).show()
                val intento1 = Intent(this, MainActivity::class.java)
                startActivity(intento1)
            }
        }
    }
}