package gregoriofer.local.ejem03_formulario

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import gregoriofer.local.ejem03_formulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        binding.bRecuperarDatos.setOnClickListener {
            Log.d("Depurando", "Pulsó ")
        }





    binding.spTipoMatricula.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("Depurando", "Selecciono: "+(view as TextView).text)
                Log.d("Depurando", "Selecciono: "+(view as TextView).text+position)
                Log.d("Depurando", "Selecciono: "+parent?.adapter?.getItem(position).toString())

                val tipoMatricula = resources.getStringArray(R.array.tiposMatricula)[position]
                binding.tvTipoMatricula.setText("Tipo de matrícula seleccionado: $tipoMatricula")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada
                Log.d("Depurando", "No selecciona nada")
            }

    }
    binding.rgCursos.setOnCheckedChangeListener { group, identifier ->
        Log.d("Depurando", "Selecciono: ${findViewById<RadioButton>(identifier).text}")

    }
    binding.tvTipoMatricula.setOnClickListener { view ->
        Log.d("Depurando", "Pulso: "+(view as TextView).text)

    }
        binding.tvEligeCurso.setOnClickListener { view ->
            Log.d("Depurando", "Pulso: "+(view as TextView).text)

        }
binding.checkBox.se


    }
}