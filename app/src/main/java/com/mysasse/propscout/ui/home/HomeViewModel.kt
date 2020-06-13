package com.mysasse.propscout.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mysasse.propscout.data.models.User

class HomeViewModel : ViewModel() {

    private val _user = MutableLiveData<User>().apply {
        value = User("Azenga Kevin", "azenga.kevin7@gmail.com")
    }
    val user: LiveData<User> = _user
}