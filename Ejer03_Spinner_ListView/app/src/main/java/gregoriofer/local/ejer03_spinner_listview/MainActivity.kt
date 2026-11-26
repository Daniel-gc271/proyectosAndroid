package gregoriofer.local.ejer03_spinner_listview

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import gregoriofer.local.ejer03_spinner_listview.databinding.ActivityMainBinding


lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var elemento: Registro? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.miDato = Registro("Pepe botella",21)



        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        val listaElementos = mutableListOf<Registro>()
        for (i in 1..10) {
            val r = Registro("E$i",i+10)
            listaElementos.add(r)
        }

        val elementosVista = ArrayAdapter<Registro>(this, android.R.layout.simple_list_item_1, listaElementos)

        binding.lista.adapter = elementosVista
        binding.spinner2.adapter = elementosVista

        binding.buttonAAdir.setOnClickListener {
            val textoAñadir: String =   binding.editTextTextEntradaNombre.text.toString()
            binding.editTextTextEntradaNombre.text.clear()
            val edadAñadir: Int = (binding.editTextTextEntradaEdad.text.toString().toInt())
            binding.editTextTextEntradaEdad.text.clear()
            if(textoAñadir.isNotEmpty()) {
                val r: Registro= Registro(textoAñadir,edadAñadir)
                listaElementos.add(r)
                Log.d("Depurando", listaElementos.toString())
                elementosVista.notifyDataSetChanged()
            }
        }

        binding.lista.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            elemento = parent.getItemAtPosition(position) as Registro
            Log.d("Depurando", elemento.toString())

        }
        binding.spinner2.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                elemento = parent?.getItemAtPosition(position) as? Registro
                Log.d("Depurando", elemento.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Opcional: qué hacer si no se selecciona nada
            }
        }
/*
        binding.lista.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            elemento = parent.getItemAtPosition(position) as Registro?
            Log.d("Depurando", "ListView: $elemento")
        }
*/
        binding.buttonEliminar.setOnClickListener {

            listaElementos.remove(elemento)
            elementosVista.notifyDataSetChanged()
        }



    }
}