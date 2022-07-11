package com.example.dbm.loginsignupheroku.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dbm.loginsignupheroku.di.DispatchersModule
import com.example.dbm.loginsignupheroku.domain.usecase.ILoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: ILoginUseCase,
    @DispatchersModule.MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    fun sendLoginData(username: String, password: String) {

        if(username.isEmpty() || password.isEmpty()){
            println("Username or password is empty")
            return
        }

        viewModelScope.launch(mainDispatcher) {
            loginUseCase(username, password)
        }
    }
}