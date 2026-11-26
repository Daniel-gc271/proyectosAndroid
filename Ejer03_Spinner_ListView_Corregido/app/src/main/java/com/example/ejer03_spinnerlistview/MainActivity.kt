
package com.example.ejer03_spinnerlistview

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer03_spinnerlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pepe=Dato("Pedro",33)

        binding.miDato=pepe

        //val lista = mutableListOf<Dato>()
        val categorias = mutableListOf<Dato>()

        var adapter: ArrayAdapter<Dato>
        var adapterSpinner: ArrayAdapter<Dato>


        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            categorias
        )

        binding.listView.adapter = adapter

        categorias.add(Dato("Java"))
        categorias.add(Dato("Kotlin",10))
        categorias.add(Dato("Python",8))
        categorias.add(Dato("SQL"))

        adapterSpinner = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            categorias
        )

        /*adapterSpinner.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )*/

        binding.spinner.adapter = adapterSpinner

        binding.btnAnadir.setOnClickListener {
            //val dato = binding.etDato.text.toString()
            //val dato:Dato?=binding.miDato
            val dato:Dato?= Dato(binding.etDato.text.toString(),binding.etNumero.text.toString().toIntOrNull() ?: 0)


           // if (dato.isNotEmpty()) {
                categorias.add(dato!!)
                adapter.notifyDataSetChanged()
                adapterSpinner.notifyDataSetChanged()
                binding.etDato.text.clear()
           // }
        }

        binding.btnBorrar.setOnClickListener {
            val posicion = binding.listView.checkedItemPosition

            if (posicion != -1) {
                categorias.removeAt(posicion)
                adapter.notifyDataSetChanged()
                binding.listView.clearChoices()
            }
        }

        binding.spinner.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                Log.d("depurando",categorias[position].toString())
            }

            override fun onNothingSelected(parent: android.widget.AdapterView<*>) {

            }
        }
       /* binding.listView.onItemClickListener = object : android.widget.AdapterView.OnItemClickListener {
            override fun onItemClick(parent: android.widget.AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                Log.d("depurando",categorias[position].toString())
            }
        }*/
        binding.listView.onItemClickListener=
            AdapterView.OnItemClickListener { parent, view, position, id ->  Log.d("depurando",categorias[position].toString())}
       

    }
}
