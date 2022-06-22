package com.kimstik.appselect.presentation.viewmodel.base

import androidx.lifecycle.ViewModel
import com.visoft.data.util.dispatcher.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

open class BaseViewModel(dispatchers: DispatcherProvider? = null) : ViewModel() {

    protected val scope: CoroutineScope by lazy {
        if (dispatchers != null) {
            CoroutineScope(SupervisorJob() + dispatchers.immediate())
        } else {
            CoroutineScope(Job())
        }
    }

    override fun onCleared() {
        scope.cancel()
        super.onCleared()
    }
}
