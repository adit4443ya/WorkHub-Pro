package com.work.workhubpro.ui.screens.loginPage

import androidx.lifecycle.ViewModel
import com.work.workhubpro.models.User
import com.work.workhubpro.repository.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
public class LoginPageViewModel @Inject constructor(private val repo: LoginRepo) : ViewModel() {
    suspend fun loginuser(username: String, email: String, password: String): Boolean {
        println(username)
        val newUser = User(username, email, password) // Create a new User instance
        return try {
            // Attempt to retrieve the user from the repository
            repo.getUser(newUser)
            // Return true if the user is successfully retrieved
            true
        } catch (e: Exception) {
            // Return false if an exception occurs (login unsuccessful)
            false
        }
    }

}
