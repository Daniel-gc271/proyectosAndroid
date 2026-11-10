package com.example.ejer01_calculadora

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejer01_calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var numero1=0
    var numero2=0;


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        /*Opcion 1
        binding.b1.setOnClickListener { boton: android.view.View ->
            binding.tvResultado.setText((boton as Button).text.toString())
        }*/
        /* Opcion2. Con funciones*/
        binding.b1.setOnClickListener(this::onClick)
        binding.b2.setOnClickListener(this::onClick)
        binding.b3.setOnClickListener(this::onClick)
        binding.b4.setOnClickListener(this::onClick)
        binding.b5.setOnClickListener(this::onClick)
        binding.b6.setOnClickListener(this::onClick)
        binding.b7.setOnClickListener(this::onClick)
        binding.b8.setOnClickListener(this::onClick)
        binding.b9.setOnClickListener(this::onClick)
        binding.bMenos.setOnClickListener(this::onClick)
        binding.bMas.setOnClickListener(this::onClick)
        binding.bIgual.setOnClickListener(this::onClick)
    }
    /*fun onClick(view: android.view.View) {
        binding.tvResultado.setText((view as Button).text.toString())
    }*/

    //var op2 = ""
    var numero2Negativo: Boolean = false
    fun onClick(view: android.view.View){
        when ((view as Button).text.toString()) {
            "+" -> {
                 numero1=binding.tvResultado.text.toString().toInt()
                binding.tvResultado.text= ""

            }
            "-" -> {
                 numero1=binding.tvResultado.text.toString().toInt()
                numero2Negativo=true
                binding.tvResultado.text= ""
            }
            "=" -> {
                Log.d("depurando","numero1: $numero1, numero2: $numero2")
                 numero2=when{
                    numero2Negativo -> binding.tvResultado.text.toString().toInt()*-1
                    else -> binding.tvResultado.text.toString().toInt()
                }
                 binding.tvResultado.text= (numero1+ numero2).toString()
            }
            else -> {
                binding.tvResultado.setText((view as Button).text.toString())
            }
        }
    }


      /*  var op = (view as Button).text.toString()

        if(op != "-" && op != "+" && op != "="){
            if(op2 == ""){
                num1 = (num1 * 10) + op.toInt()
                binding.tvResultado.setText(num1.toString())
            }
            else{
                num2 = (num2 * 10) + op.toInt()
                binding.tvResultado.setText(num2.toString())
            }

        }
        else if (op == "+" || op == "-") {
            op2 = op
        }
        else if (op == "=") {
            if (op2 == "+"){
                resultado = num1 + num2
            }
            else if (op2 == "-"){
                resultado = num1 - num2
            }

            binding.tvResultado.setText(resultado.toString())

            num1 = resultado
            num2 = 0
            op2 = ""
        }*/

}