package com.kimstik.appselect.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kimstik.appselect.data.network.FilmApi
import com.kimstik.appselect.presentation.viewmodel.MainViewModel
import com.kimstik.appselect.repository.NetworkRepository
import com.visoft.data.util.dispatcher.DispatcherProvider

class MainViewModelFactory(private val repos: NetworkRepository,
                           private val dispatchers: DispatcherProvider): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repos, dispatchers) as T
    }
}