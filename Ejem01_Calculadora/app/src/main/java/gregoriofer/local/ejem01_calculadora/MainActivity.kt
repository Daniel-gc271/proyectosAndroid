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
        binding.btn0.setOnClickListener(this::onClick)

    }

    private fun onClick(view: android.view.View) {
        binding.tvRes.setText((view as Button).text.toString())

    }




}