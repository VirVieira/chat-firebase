package com.pedromoura.chatfirebase.presentation.login

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.core.Context
import kotlinx.coroutines.launch

class LoginViewModel(@SuppressLint("RestrictedApi")
    private val context: Context
) : ViewModel() {
    private val SharedPreferences: SharedPreferences = context.getSharedPreferences(
        "login_prefs",
        Context.MODE_PRIVATE
    )
    var userId: String = ""
    var username: String = ""
    var passaword: String = ""

    @SuppressLint("CommitPrefEdits")
    fun saveCredentials(username: String, password: String) {
        userId = if (username == "username") {
            "1"
        } else {
            "2"
        }
        viewModelScope.launch {
            with(SharedPreferences.edit()) {
                putString("USERID", userId)
                putString("USERNAME", userId)
                putString("PASSWORD", userId)
                apply()
            }
        }
    }
}
class LoginViewModelFactory(@SuppressLint("RestrictedApi")
                            private val context: android.content.Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(context) as T
    }
    throw IllegalArgumentException("ViewModel Class Desconhecido")
        return super.create(modelClass)
    }
}