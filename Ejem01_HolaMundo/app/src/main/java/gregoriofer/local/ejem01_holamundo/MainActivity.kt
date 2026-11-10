package gregoriofer.local.ejem01_holamundo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import gregoriofer.local.ejem01_holamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //setContentView(R.layout.activity_main)

       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        Log.d("depurando","hola mundo consola")

        //findViewById<TextView>(R.id.tvSaludar).setText("hola")
        //findViewById<TextView>(R.id.tvSaludar).setText(R.string.saludoInicial)
        binding.tvSaludar.setText(R.string.saludo_inicial)

        binding.bSaludar.setOnClickListener {
            binding.tvSaludar.setText(binding.tietNombre.text.toString())
        }
        variables()
        estructurasCondicionales()
        bucles()

    }

    private fun bucles() {

        val lista= listOf<String>("Juan","Pedro","Maria")
        for (nombre in lista){
            Log.d("depurando","nombre: $nombre")
        }

        for (i in 0..10){
            Log.d("depurando","i: $i")
        }

        for (i in 0 until 10){
            Log.d("depurando","i: $i")
        }

        for (i in 10 downTo 0 step 2){
            Log.d("depurando","i: $i")
        }
        lista.forEach {nombre->

            Log.d("depurando","i: $nombre")
        }
        lista.forEach {

            Log.d("depurando","i: $it")
        }
}

    private fun estructurasCondicionales() {
        val numero=0
        var resultado = if (numero==0) "Hola Juan" else "No eres Juan"
        Log.d("depurando","resultado: $resultado")
        resultado = when(numero){
            0 -> "Hola Juan"
            1 -> "Hola Pedro"
            else -> "No eres Juan ni Pedro"
        }
        Log.d("depurando","resultado: $resultado")

        val dia=3
        val diaSemana= when(dia){
            1-5 -> "Dia laboral"
            6,7 -> "Fin de semana"
            else -> "Dia no valido"
        }


    }

    private fun variables() {
        val nombre = "Juan" // Inmutable
        //nombre = "Pedro" // Error.
        val edad: Int = 30

        val curso:String = if (edad >= 18) "Android" else "Kotlin"

        val lista=mutableListOf<Int>()
        lista.add(1)
        lista.add(2)
        lista.add(3)
       // lista=mutableListOf<Int>()
        Log.d("depurando","nombre: $nombre, edad: $edad, curso: $curso, lista: $lista")
        Log.d("depurando","nombre:"+ nombre+", edad:"+ edad +", curso: "+ curso)

        val suma:Double =3+4.5
        val numeroDeString:Int = "123".toInt()
        val valor:Int? ="abc".toIntOrNull()

    }


}