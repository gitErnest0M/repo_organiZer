package com.example.organizer_v5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class crearTareaActivity : AppCompatActivity() {
    var editTxt:EditText?=null
    var ingresarTareaTxt:EditText?=null
    var btnFecha:ImageButton?=null
    var btnGuardar:Button?=null
    var dpFecha:DatePicker?=null
    var fechaSeleccionada:String?=null
    var nombreActividad:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear_tarea)

        btnGuardar= findViewById(R.id.btnGuardar)
        editTxt = findViewById(R.id.nuevaActividadTxt)
        ingresarTareaTxt = findViewById(R.id.ingresarTareaTxt)
        btnFecha = findViewById(R.id.btnFecha)
        dpFecha = findViewById(R.id.dpFecha)
       nombreActividad= findViewById(R.id.ingresarTareaTxt)


        editTxt?.setText(getDatePickerFecha())

        dpFecha?.setOnDateChangedListener{
            dpFecha,anio,mes,dia->
            editTxt?.setText(getDatePickerFecha())
            dpFecha?.visibility=View.GONE
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    @SuppressLint("SuspiciousIndentation")
    private fun getDatePickerFecha(): String {
    var dia = dpFecha?.dayOfMonth.toString().padStart(2,'0')
    var mes = (dpFecha!!.month+1).toString().padStart(2,'0')
    var anio = dpFecha?.year.toString().padStart(4,'0')
        println(dia+"/"+mes+"/"+anio)
        fechaSeleccionada= dia+"/"+mes+"/"+anio
        println("fecha")
        return dia+"/"+mes+"/"+anio
    }

    fun mostrarCalendario(view:View){
        dpFecha?.visibility= View.VISIBLE

    }

    fun crearEvento(view: View) {
        println("entro al dar click en boton guardar")
        var nombActivGuardar:String=nombreActividad?.text.toString()
        println(fechaSeleccionada)
        println(nombActivGuardar)

    }
}