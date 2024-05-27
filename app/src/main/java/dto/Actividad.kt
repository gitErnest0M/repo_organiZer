package dto

class Actividad {
    var nombreActividad: String? = null
    var fecha: String? = null

    constructor(nombreActividad: String?, fecha: String?) {
        this.nombreActividad = nombreActividad
        this.fecha = fecha
    }

    constructor()
}
