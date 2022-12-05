package com.example.solidprinciples.data

import com.example.solidprinciples.data.model.LoggedInUser
import java.io.File

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(
    val dataSource: LoginDataSource,
    val fileLogger: FileLogger
) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    /**
     * Single responsability: reason to change
     * Responsabilidad única: Al final de cuentas son las razones para cambiar una función.
     * Entonces no importa la clase o la función, éstas deben tener sólo una reponsabiliad
     * y una razón para cambiar
     */
    fun login(username: String, password: String): Result<LoggedInUser> {
        // con ésta línea manejamos el login de la aplicación
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        } else {
            // A través del file logger manejamos el error
            // Ahora si lo quisieramos cambiar no tendríamos que modificar esta función
            fileLogger.logError((result as Result.Error).toString())
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}