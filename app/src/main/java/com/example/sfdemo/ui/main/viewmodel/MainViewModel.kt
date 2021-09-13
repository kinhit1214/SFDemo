package com.example.sfdemo.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sfdemo.ui.main.model.AppState
import com.example.sfdemo.ui.main.model.Repository
import com.example.sfdemo.ui.main.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private  val repositoryImpl : Repository = RepositoryImpl()) :
    ViewModel() {

    fun getData():LiveData<AppState>{
        getFilmFromLocalSource()
        return liveDataToObserve
    }

    fun getFilmFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread{
            sleep(5000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getFilmFromLocalStorage()))
        }.start()
    }
}