package com.kimstik.appselect.presentation.viewmodel

import com.google.gson.Gson
import com.kimstik.appselect.presentation.viewmodel.base.BaseViewModel
import com.kimstik.appselect.repository.NetworkRepository
import com.visoft.data.util.dispatcher.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SplashViewModel(private val repos: NetworkRepository, dispatchers: DispatcherProvider): BaseViewModel(dispatchers) {

    val item: MutableStateFlow<String?> = MutableStateFlow(null)

    init {
        preloadData()
    }

    private fun preloadData() {
        scope.launch {
            val data = repos.getData(offset = 0)
            if(data != null) {
                val json = Gson().toJson(data)
                item.value = json
            }else{
                preloadData()
            }
        }
    }
}
