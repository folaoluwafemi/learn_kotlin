package com.example.learnkotlin.model

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LearnerViewModel: ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get()= _name

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get()= _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get()= _password

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    fun setName(name: String){
        _name.value = name
    }
    fun setUserName(user_name: String){
        _userName.value = user_name
    }
    fun setPassword(password: String){
        _password.value = password
    }
    fun setEmail(email: String){
        _email.value = email
    }
    fun hasAccount(): Boolean{
        if(_name.value.isNullOrEmpty() || _email.value.isNullOrEmpty() || _password.value.isNullOrEmpty())
            return false
        return true
    }
}