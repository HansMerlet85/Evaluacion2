package com.example.evaluacion2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class IniSesion : AppCompatActivity() {

    val compartidaP = "com.example.evaluacion2.preferences_ini_sesion" // Nombre de preferencias compartidas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ini_sesion)

        // Valores de formularios
        val codigoInit = findViewById<TextView>(R.id.codinit)
        val descripcionInit = findViewById<TextView>(R.id.descinit)
        val precioInit = findViewById<TextView>(R.id.prizeinit)

        // Valores de los botones
        val crearBotoninit = findViewById<Button>(R.id.crearinit)

        // Listener del botón crearBotoninit
        crearBotoninit.setOnClickListener {
            val compP = getSharedPreferences(compartidaP, Context.MODE_PRIVATE)
            val editor = compP.edit()

            // Guardar los valores en las preferencias compartidas
            editor.putString("codigoInit", codigoInit.text.toString())
            editor.putString("descripcionInit", descripcionInit.text.toString())
            editor.putString("precioInit", precioInit.text.toString())

            editor.apply() // Guardar los cambios en las preferencias compartidas
        }
    }
}