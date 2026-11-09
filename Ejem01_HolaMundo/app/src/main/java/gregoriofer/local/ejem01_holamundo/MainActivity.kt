package gregoriofer.local.ejem01_holamundo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import gregoriofer.local.ejem01_holamundo.databinding.ActivityMainBinding

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

        //binding.tvSaludar.setText(R.string.saludo_inicial)
        /*
        findViewById<TextView>(R.id.tvSaludar).setText(R.string.saludo_inicial)
        Log.d("depurando", "Holamundo depurando ")
        variables()
        */
        binding.bSaludar.setOnClickListener {
            binding.tvSaludar.setText(binding.tietNombre.text.toString())
            //binding.tvSaludar.setText(R.string.saludo_inicial)

        }


    }

    private fun variables() {

        val nombre:String = "juan"
        val edad:Int =16
        val curso: String = if (edad>=18) "mayor" else "menor"
        val nombres = mutableListOf<String>()
        nombres.add("bubri")
        nombres.add("kurva")
        nombres.add("nawui")
        nombres.add("Pizdets")
        nombres.add("Mudak")
        nombres.add("Suka")

        Log.d("depurando", "nombres: $nombres, edad:$edad, curso:$curso" )
        nombres.replaceAll { it.uppercase() }
        Log.d("depurando", "nombres mayuscula: $nombres, edad:$edad, curso:$curso" )

        val suma:Double = 3 + 4.5
        val numeroDeString:Int = "123".toInt()
        val valor:Int ?= "abc".toIntOrNull()

    }
}