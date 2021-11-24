package com.example.recetarioapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import com.example.appejemplosqlite.AdminSQLite
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener


class Recetas : AppCompatActivity() {

    private var listView: ListView? = null
    private var recetaList: MutableList<RecetaModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas)

        val bundle = intent.extras
        val tipoReceta = bundle?.getInt("tipoReceta")

        listView = findViewById(R.id.listViewData) as ListView
        recetaList = mutableListOf<RecetaModel>()
        if (tipoReceta != null) {
            loadRecetas(tipoReceta)
        }

        listView!!.setOnItemClickListener(
            OnItemClickListener { parent, view, position, id -> // Abre una nueva Activity:
                val myIntent = Intent(view.context, RecetaSeleccionada::class.java)
                startActivity(myIntent)
            }
        )
    }



    private fun loadRecetas(tipoReceta: Int) {
        val receta = AdminSQLite(this,"receta",null,1)
        val bd = receta.writableDatabase
        val c = bd.rawQuery("SELECT * FROM receta WHERE tipo = '${tipoReceta}'", null)
        if (c.moveToFirst()) {
            do {
                val obj = RecetaModel(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5))
                recetaList!!.add(obj)
                val adapter = Item_Adapter(this@Recetas, recetaList!!)
                listView!!.adapter = adapter
            } while (c.moveToNext())
        }
        c.close()

    }
}