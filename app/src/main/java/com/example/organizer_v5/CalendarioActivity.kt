package com.example.organizer_v5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import clases.Utilidades

class CalendarioActivity : AppCompatActivity() {
    val utilidad = Utilidades()
    var listaActividades:ListView? = null

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendario)

        /**
         * Mensaje para crear una actividad
         * */
        val mensajeParaListaActividad = findViewById<TextView>(R.id.listaActividad)
        mensajeParaListaActividad.setOnClickListener {
            Toast.makeText(this, "Para crear una actividad seleccione \nCrear Actividad de lo contrario oprima \nCancela Operación", Toast.LENGTH_LONG).show()
        }

        /**
         * Para transición entre layout
         * */
        val irCrear : Button = findViewById(R.id.bt_irCrearActividad)
        irCrear.setOnClickListener{
            val intent: Intent = Intent(this, crearTareaActivity::class.java)
            startActivity(intent)
        }

        val salir : Button = findViewById(R.id.salir)
        salir.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            utilidad.limpiarLista()
        }


        /**
         * Recibe el nombre: lista de actividades y realiza la validación si el campo está vacio o no
         * si esta vacia no muestra nada
         * si esta llena muestra las actividdes
         * */
        var lista = utilidad.convertirData()
        if (lista != null && !lista!!.isEmpty()) {
            listaActividades = findViewById(R.id.listaTareas)
            var adaptador : ArrayAdapter<String> = ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,lista)
            listaActividades?.adapter = adaptador
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}