package com.example.churraspar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Definindo os IDs dos campos de entrada e botões
    private lateinit var inputHomens: EditText
    private lateinit var inputMulheres: EditText
    private lateinit var inputCriancas: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpar: Button
    private lateinit var resultadoCarne: TextView
    private lateinit var resultadoAperitivos: TextView
    private lateinit var resultadoBebidasAlcoolicas: TextView
    private lateinit var resultadoAgua: TextView
    private lateinit var resultadoRefrigerante: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando os componentes de interface
        inputHomens = findViewById(R.id.menEditText)
        inputMulheres = findViewById(R.id.womenEditText)
        inputCriancas = findViewById(R.id.kidsEditText)
        btnCalcular = findViewById(R.id.calculateButton)
        btnLimpar = findViewById(R.id.clearButton)
        resultadoCarne = findViewById(R.id.resultadoCarne)
        resultadoAperitivos = findViewById(R.id.resultadoAperitivos)
        resultadoBebidasAlcoolicas = findViewById(R.id.resultadoBebidasAlcoolicas)
        resultadoAgua = findViewById(R.id.resultadoAgua)
        resultadoRefrigerante = findViewById(R.id.resultadoRefrigerante)

        btnCalcular.setOnClickListener {
            calcularChurrasco()
        }

        btnLimpar.setOnClickListener {
            limparCampos()
        }
    }

    private fun calcularChurrasco() {
        val homens = inputHomens.text.toString().toIntOrNull() ?: 0
        val mulheres = inputMulheres.text.toString().toIntOrNull() ?: 0
        val criancas = inputCriancas.text.toString().toIntOrNull() ?: 0

        // Calcular a quantidade de carne (com margem de 10%)
        val carneHomens = homens * 400
        val carneMulheres = mulheres * 300
        val carneCriancas = criancas * 200
        val totalCarne = (carneHomens + carneMulheres + carneCriancas) * 1.1

        // Calcular a quantidade de aperitivos (com margem de 10%)
        val aperitivosHomens = homens * 150
        val aperitivosMulheres = mulheres * 100
        val aperitivosCriancas = criancas * 50
        val totalAperitivos = (aperitivosHomens + aperitivosMulheres + aperitivosCriancas) * 1.1

        // Calcular a quantidade de bebida alcoólica (com margem de 10%)
        val bebidasHomens = homens * 4.0
        val bebidasMulheres = mulheres * 2.0
        val totalBebidasAlcoolicas = (bebidasHomens + bebidasMulheres) * 1.1

        // Calcular a quantidade de água e refrigerante (com margem de 10%)
        val totalAgua = (mulheres * 2 + criancas * 2) * 1.1
        val totalRefrigerante = (mulheres * 1.5 + criancas * 1.5) * 1.1

        resultadoCarne.text = "%.2f kg".format(totalCarne / 1000)  // Converter para kg
        resultadoAperitivos.text = "%.2f kg".format(totalAperitivos / 1000)  // Converter para kg
        resultadoBebidasAlcoolicas.text = "%.2f L".format(totalBebidasAlcoolicas)
        resultadoAgua.text = "%.2f L".format(totalAgua)
        resultadoRefrigerante.text = "%.2f L".format(totalRefrigerante)
    }

    private fun limparCampos() {
        inputHomens.text.clear()
        inputMulheres.text.clear()
        inputCriancas.text.clear()
        resultadoCarne.text = ""
        resultadoAperitivos.text = ""
        resultadoBebidasAlcoolicas.text = ""
        resultadoAgua.text = ""
        resultadoRefrigerante.text = ""
    }
}
