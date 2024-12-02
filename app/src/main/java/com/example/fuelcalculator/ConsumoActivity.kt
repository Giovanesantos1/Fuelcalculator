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

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)

        val consumo = intent.getFloatExtra("123", 0f)

        val edtconsumo = findViewById<TextInputEditText>(R.id.edt_consumo)
        val button2 = findViewById<Button>(R.id.btn_next2)

        button2.setOnClickListener {

            val consumostr: String = edtconsumo.text.toString()

            if (consumostr == "") {
                Snackbar.make(edtconsumo, "Preencha o campo vazio", Snackbar.LENGTH_LONG).show()

            } else {
                val consumo = consumostr.toFloat()

                val intent = Intent(this, quilometroActivity::class.java)
                intent.putExtra("123", consumo)
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