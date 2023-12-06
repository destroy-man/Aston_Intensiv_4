package ru.korobeynikov.astonintensiv4.second.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private var mutableLiveData = MutableLiveData<ArrayList<User>>()
    var liveData: LiveData<ArrayList<User>> = mutableLiveData

    fun loadData(data: ArrayList<User>) {
        mutableLiveData.value = data
    }
}