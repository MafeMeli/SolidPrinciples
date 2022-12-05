package com.example.solidprinciples.data

import java.io.File

/**
 * Ésta clase tiene la única responsabilidad de loggear el error.
 * La O en SOLID corresponde a Open for extention but closed for modification.
 */

/**
 * La I corresponde a Interface Segregation: Una clase que implementa una interfaz
 * no debe de ser forzada a usar métodos que no necesita
 */
interface FileLogger {

    fun printLogs() {
        // Default behavior
    }


    // Que pasa si queremos cambiar la manera en que logueamos el error?
    fun logError(error: String){
        // En caso de error lo guardamos en un archivo de error
        // Cambiar simplemente el nombre del archivo estaría mal, podría generar conflictos.
        // Porque donde quiera que usemos esta clase en nuestro código, cambiaría la manera en que
        // logueamos nuestros errores y tal vez no es lo que queremos.
        // No queremos afectar to do el codigo con sólo un cambio
        val file = File("error.txt")
        file.appendText(
            text = error
        )
    }

}

class CustomFileLogger: FileLogger {

    /**
     * Podemos crear una clase nueva que extienda de una clase padre
     * y modificar su comportamiento para que se ajuste a lo que necesitamos
     * sin modificar a la clase padree.
     */
    override fun logError(error: String) {
        val file = File("my_custom_error_file.txt")
        file.appendText(
            text = error
        )
    }
}
