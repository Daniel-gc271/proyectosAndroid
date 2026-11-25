package gregoriofer.local.ejer03_spinner_listview

import android.os.Bundle
import android.util.Log
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



        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        val listaElementos = mutableListOf<Registro>()

        for (i in 1..10) {
            val r: Registro= Registro("E$i")
            listaElementos.add(r)
        }
        val elementosVista =ArrayAdapter(this, android.R.layout.simple_list_item_1, listaElementos)


        binding.lista.adapter = elementosVista
        binding.spinner2.adapter = elementosVista

        binding.buttonAAdir.setOnClickListener {
            val textoAñadir: String =   binding.editTextTextEntrada.text.toString()
            binding.editTextTextEntrada.text.clear()
            if(textoAñadir.isNotEmpty()) {
                val r: Registro= Registro(textoAñadir)
                listaElementos.add(r)
                Log.d("Depurando", listaElementos.toString())
            }
        }

        binding.lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            elemento = parent.getItemAtPosition(position) as Registro
            Log.d("Depurando", elemento.toString())

        }


        binding.lista.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            elemento = parent.getItemAtPosition(position) as Registro?
            Log.d("Depurando", "ListView: $elemento")
        }

        binding.buttonEliminar.setOnClickListener {

            listaElementos.remove(elemento)
            elementosVista.notifyDataSetChanged()
        }



    }
}