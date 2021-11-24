package com.example.recetarioapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Item_Adapter(private val context: Activity, internal var datas: List<RecetaModel>) : ArrayAdapter<RecetaModel>(context, R.layout.receta_item, datas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val listViewItem = inflater.inflate(R.layout.receta_item, null, true)

        val txtNombre = listViewItem.findViewById(R.id.txtNombre) as TextView



        val data = datas[position]
        txtNombre.text = data.nombre


        return listViewItem
    }
}