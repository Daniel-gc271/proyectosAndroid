package com.example.ejem03_formulario

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.example.ejem03_formulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        binding.bRecuperar.setOnClickListener { view ->
            Log.d("depurando", "Pulsó....."+(view as Button).text.toString())
        }

        binding.spTipoMatricula.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("depurando", "Seleccionó: "+(view as TextView).text.toString())
                Log.d("depurando", "Seleccionó: "+position)
                Log.d("depurando", "Seleccionó a través de parent:"+parent?.adapter?.getItem(position).toString())

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("depurando", "No seleccionó nada")
            }
        }

        binding.rgCursos.setOnCheckedChangeListener { group, i ->
            Log.d("depurando","Seleccionó: "+ findViewById<RadioButton>(i).text.toString())


        }

        binding.tvEligeCurso.setOnClickListener { texto ->
            // Log.d("depurando","Pulsó el texto: "+binding.tvEligeCurso.text.toString())
            Log.d("depurando","Pulsó el texto: "+(texto as TextView).text.toString())

        }
        binding.cbRepetidor.setOnCheckedChangeListener { _, isChecked ->

            Log.d("depurando", "El alumno es: ${if (isChecked) "repetidor" else "no repetidor"}")
        }
        val alumno: Alumno = Alumno(true, "juan", "Ordinaria","Primero")
        Alumno(nombre = "Pedro", tipoMatricula = "Extraordinaria")
        Log.d("Depurando", alumno.toString())



    }
}