package com.example.fuelcalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_FUEL = "Key fuel"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_FUEL, 0f)

        val tvPreco = findViewById<TextView>(R.id.tv_resul_preço)
        val tvconsumo = findViewById<TextView>(R.id.tv_resul_consumo)
        val tvkm = findViewById<TextView>(R.id.tv_resul_km)

        tvPreco.text = result.toString()
        tvconsumo.text = result.toString()
        tvkm.text = result.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}