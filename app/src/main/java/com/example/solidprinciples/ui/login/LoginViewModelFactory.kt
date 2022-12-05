package com.example.solidprinciples.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.solidprinciples.data.CustomFileLogger
import com.example.solidprinciples.data.FileLogger
import com.example.solidprinciples.data.LoginDataSource
import com.example.solidprinciples.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    /**
     * Liskov sustitution: Las clases padre deben de poder ser sustituidas por las clases hijas.
     */
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource(),
                    fileLogger = CustomFileLogger()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}