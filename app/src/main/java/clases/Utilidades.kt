package clases

import dto.Actividad

class Utilidades {
    fun llenarLista(actividad: Actividad) {
        var nuevaAct = Actividad()
        nuevaAct = actividad
        listaTareas.add(nuevaAct)
    }

    fun convertirData(): List<String> {
        for (act in listaTareas) {
            val tareaCreada = act.fecha + " " + act.nombreActividad + "\n" + usuario
            listaFinal.add(tareaCreada)
        }
        return listaFinal
    }

    fun consultarActividades(): List<Actividad> {
        return listaTareas
    }

    fun limpiarLista() {
        listaTareas.clear()
    }

    fun validarUsuario(userVista:String,passwVista:String ): Boolean{
        if (usuario.equals(userVista.toString()) && passwVista.equals(contrasena.toString())){
            return true
        }else{
            return false
        }

    }

    companion object {
        private val listaTareas: MutableList<Actividad> = ArrayList()
        private val listaFinal: MutableList<String> = ArrayList()
        private val  usuario :String = "admin"
        private val  contrasena :String = "123"
    }
}
