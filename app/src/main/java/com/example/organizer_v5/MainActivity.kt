package com.example.organizer_v5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import clases.Utilidades

class MainActivity : AppCompatActivity() {
    val utilidad = Utilidades()
    var usuario: EditText?=null
    var contrasena:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /**
         * Validación del login (con usuario previo asignado) capturado desde layout
         * */
        usuario = findViewById(R.id.usuario)
        contrasena = findViewById(R.id.contrasena)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /**
         * Mensaje para el logo
         * */
        val mensajeInicial = findViewById<ImageView>(R.id.logoInicial)
        mensajeInicial.setOnClickListener {
            Toast.makeText(this, "Hola! Ingresa con un usuario registrado de tu Organización", Toast.LENGTH_SHORT).show()
        }
    }
    /**
     * Función para validar usuario de datos capturados
     * */
    fun validarLogin(view: View) {
        var usuarioCapturado:String=usuario?.text.toString()
        var passwCapturado:String=contrasena?.text.toString()
        val validar = utilidad.validarUsuario(usuarioCapturado, passwCapturado)

        if (validar) {
            val sigCalendario: Button = findViewById(R.id.bt_irCAlendario)
            sigCalendario.setOnClickListener {
                val intent: Intent = Intent(this, CalendarioActivity::class.java)
                startActivity(intent)
            }
        }else{
            Toast.makeText(this, "Usuario o Contraseña incorrecto", Toast.LENGTH_SHORT).show()
        }
    }
}