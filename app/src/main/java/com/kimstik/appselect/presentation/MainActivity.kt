package com.kimstik.appselect.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimstik.appselect.databinding.ActivityMainBinding
import com.kimstik.appselect.presentation.adapters.RecyclerAdapter
import com.kimstik.appselect.presentation.viewmodel.MainViewModel
import com.kimstik.appselect.presentation.viewmodel.factory.MainViewModelFactory
import com.kimstik.appselect.util.AppApplication
import com.kimstik.appselect.util.BUNDLE_KEY
import com.kimstik.appselect.util.RecyclerScrollListener
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    private var bind: ActivityMainBinding? = null
    private var recyclerAdapter: RecyclerAdapter = RecyclerAdapter()
    private var manager: LinearLayoutManager = LinearLayoutManager(this)

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        bind?.recycler?.apply {
            adapter = recyclerAdapter
            layoutManager = manager
        }
        setContentView(bind?.root)
        (AppApplication.INSTANCE as AppApplication).appComponent.injectMainViewModel(this)
        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

        startActivityData(intent.getStringExtra(BUNDLE_KEY))

        lifecycleScope.launchWhenStarted {
            vm.filmList.collect{
                recyclerAdapter.updateData(it)
            }
        }
        recyclerSettings()
    }

    private fun startActivityData(data: String?){
        vm.startActivityData(data)
    }

    private fun recyclerSettings(){
        bind?.recycler?.addOnScrollListener(object : RecyclerScrollListener(manager){
            override fun loadMore(itemCount: Int) {
                vm.loadMore(itemCount)
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        bind = null
    }
}