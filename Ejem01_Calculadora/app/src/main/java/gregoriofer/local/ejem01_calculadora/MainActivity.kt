package gregoriofer.local.ejem01_calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import gregoriofer.local.ejem01_calculadora.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
		private val operacion = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        // Números
binding.btn0.setOnClickListener(this::onClick)
binding.btn1.setOnClickListener(this::onClick)
binding.btn2.setOnClickListener(this::onClick)
binding.btn3.setOnClickListener(this::onClick)
binding.btn4.setOnClickListener(this::onClick)
binding.btn5.setOnClickListener(this::onClick)
binding.btn6.setOnClickListener(this::onClick)
binding.btn7.setOnClickListener(this::onClick)
binding.btn8.setOnClickListener(this::onClick)
binding.btn9.setOnClickListener(this::onClick)

// Operadores
binding.btnAdd.setOnClickListener(this::onClick)
binding.btnSub.setOnClickListener(this::onClick)
binding.btnMult.setOnClickListener(this::onClick)
binding.btnDiv.setOnClickListener(this::onClick)

// Resultado
binding.btnRes.setOnClickListener {
    calcularResultado()
}


    }

    private fun onClick(view: android.view.View) {
    val texto = (view as Button).text.toString()

    operacion.append(texto)

    binding.tvRes.text = operacion.toString()
}
private fun calcularResultado() {
    try {
        val expresion = operacion.toString()

        val regex = Regex("""(-?\d+(?:\.\d+)?)([+\-*/])(-?\d+(?:\.\d+)?)""")
        val resultadoMatch = regex.matchEntire(expresion)
            ?: throw IllegalArgumentException("Operación inválida")

        val num1 = resultadoMatch.groupValues[1].toDouble()
        val operador = resultadoMatch.groupValues[2]
        val num2 = resultadoMatch.groupValues[3]

        val resultado = when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 == 0.0) throw ArithmeticException("División por cero")
                num1 / num2
            }
            else -> throw IllegalArgumentException("Operador inválido")
        }

        binding.tvRes.text = resultado.toString()

        operacion.clear()
        operacion.append(resultado)

    } catch (e: Exception) {
        binding.tvRes.text = "Error"
        operacion.clear()
    }
}



}