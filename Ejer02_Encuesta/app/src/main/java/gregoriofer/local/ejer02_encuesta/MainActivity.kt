package gregoriofer.local.ejer02_encuesta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ResultadoEncuesta
import android.util.Log
import gregoriofer.local.ejer02_encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        binding.button.setOnClickListener {
            val resultado = obtenerResultado()
            // Aquí ya tienes el objeto listo para guardar, mostrar o enviar
            Log.d("Depurando", "Resultado: ${resultado}")
        }
    }
    fun obtenerResultado():ResultadoEncuesta {
        val nombre: String = binding.editTextName.text.toString().trim()
        val estadoCivil: String = when {
            binding.radioButtonSoltero.isChecked->"Soltero"
            binding.radioButtonCasado.isChecked->"Casado"
            else->""
        }

        val deportesSeleccionados = buildList {
            if (binding.checkBox.isChecked) add("Futbol")
            if (binding.checkBox2.isChecked) add("Baloncesto")
            if (binding.checkBox3.isChecked) add("Balonmano")
        }
        val deportes = deportesSeleccionados.joinToString(", ")
        val provincia: String = binding.spinner.selectedItem?.toString().orEmpty()



        return ResultadoEncuesta(
            nombre = nombre,
            deportes = deportes,
            provincia = provincia,
            soltero = estadoCivil
        )


    }
}