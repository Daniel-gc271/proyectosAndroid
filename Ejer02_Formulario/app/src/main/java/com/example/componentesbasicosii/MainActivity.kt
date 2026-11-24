package com.example.componentesbasicosii

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.componentesbasicosii.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pedro = Persona("juan","Soltero", "Valladolid", true,3)
        if (pedro.vivo) {
            Log.d("Depurando", "Pedro esta vivo ")
        } else{
            Log.d("Depurando", "Pedro esta vivo ")
        }
        binding.usuario=pedro
        val listaUsuariosInicial = mutableListOf<Persona>()
        listaUsuariosInicial.add(pedro)
        binding.listViewUsuarios.adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUsuariosInicial)












        binding.bGuardar.setOnClickListener {

            val nombre = binding.etNombre.text.toString()

            var estado = ""
            when {
                binding.rbSoltero.isChecked -> estado = "Soltero"
                binding.rbCasado.isChecked -> estado = "Casado"
            }
            val ciudad = binding.spCiudad.selectedItem.toString()

            val deportes = mutableListOf<String>()
            if(binding.cbFutbol.isChecked)deportes.add("Futbol")
            if (binding.cbBaloncesto.isChecked) deportes.add("Baloncesto")
            if (binding.cbTenis.isChecked) deportes.add("Tenis")

            val textoDeportes = if(deportes.isEmpty()){
                "Ninguno"
            }else{
                deportes.joinToString (", ")
            }
            Log.d("depurando", "Nombre: $nombre | Estado: $estado | Ciudad: $ciudad | Deportes: $textoDeportes")
        }


    }
}