package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class quilometroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quilometro)

        val quilometro = intent.getFloatExtra("KEY_FUEL", 0f)

        val edtquilometro = findViewById<TextInputEditText>(R.id.edt_km)
        val button3 = findViewById<Button>(R.id.btn_result)

        button3.setOnClickListener {

            val quilometrostr: String = edtquilometro.text.toString()

            if (quilometrostr == "") {
                Snackbar.make(edtquilometro, "Preencha o campo vazio", Snackbar.LENGTH_LONG).show()

            } else {

                val valor = intent.getFloatExtra("KEY_FUEL", 0f)
                val consumo = intent.getFloatExtra("KEY_FUEL", 0f)
                val quilometro = intent.getFloatExtra("KEY_FUEL", 0f)

                val conta = consumo * quilometro / 100
                val result = conta * valor

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("KEY_FUEL", quilometro)
                intent.putExtra("KEY_FUEL", result)
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}