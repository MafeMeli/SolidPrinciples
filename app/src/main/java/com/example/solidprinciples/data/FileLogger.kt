package com.example.solidprinciples.data

import java.io.File

/**
 * Ésta clase tiene la única responsabilidad de loggear el error.
 * La O en SOLID corresponde a Open for extention but closed for modification.
 */
class FileLogger {


    // Que pasa si queremos cambiar la manera en que logueamos el error?
    fun logError(error: String){
        // En caso de error lo guardamos en un archivo de error
        // Cambiar simplemente el nombre del archivo estaría mal, podría generar conflictos.
        val file = File("error2.txt")
        file.appendText(
            text = error
        )
    }

}
