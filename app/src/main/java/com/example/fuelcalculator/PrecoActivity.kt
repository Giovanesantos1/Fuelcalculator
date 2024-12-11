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

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco)

        val valor = intent.getFloatExtra("KEY_FUEL", 0f)

        val edtValor = findViewById<TextInputEditText>(R.id.edt_valor)
        val button = findViewById<Button>(R.id.btn_next)

        button.setOnClickListener {

            val valorstr: String = edtValor.text.toString()

            if (valorstr == "") {
                Snackbar.make(edtValor, "Preencha o campo vazio", Snackbar.LENGTH_LONG).show()

            } else {
                val valor = valorstr.toFloat()

                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("KEY_FUEL", valor)
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