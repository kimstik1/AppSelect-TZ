package com.kimstik.appselect.presentation.viewmodel

import android.util.Log
import com.google.gson.Gson
import com.kimstik.appselect.data.network.model.ApiSchema
import com.kimstik.appselect.data.network.model.Results
import com.kimstik.appselect.presentation.viewmodel.base.BaseViewModel
import com.kimstik.appselect.repository.NetworkRepository
import com.visoft.data.util.dispatcher.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repos: NetworkRepository, dispatchers: DispatcherProvider): BaseViewModel(dispatchers) {

    private val _filmList: MutableStateFlow<List<Results>> = MutableStateFlow(listOf())
    val filmList: StateFlow<List<Results>> get() = _filmList.asStateFlow()


    fun startActivityData(data: String?) {
        if(data != null) {
            val k = Gson().fromJson(data, ApiSchema::class.java)
            if(k?.listResult != null) {
                _filmList.value = k.listResult!!
            } else {
                loadMore()
            }
        } else {
            loadMore()
        }
    }

    fun loadMore(itemCount: Int = 0) {
        scope.launch {
            apiCall(itemCount).join()
        }
    }

    private fun apiCall(itemCount: Int = 0) = scope.launch {

        Log.wtf("ItemCount", itemCount.toString())
        val extraFilmList = repos.getData(offset = itemCount)

        if(extraFilmList?.listResult == null) {
            loadMore()
        } else {
            try {
                _filmList.value = extraFilmList.listResult!!
            } catch(e: Exception) {
                loadMore()
            }
        }
    }
}
