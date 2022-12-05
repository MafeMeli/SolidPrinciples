package com.example.solidprinciples.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.solidprinciples.data.FileLogger
import com.example.solidprinciples.data.LoginDataSource
import com.example.solidprinciples.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource(),
                    fileLogger = FileLogger()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}