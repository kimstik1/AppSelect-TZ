package com.kimstik.appselect.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kimstik.appselect.R
import com.kimstik.appselect.presentation.viewmodel.SplashViewModel
import com.kimstik.appselect.presentation.viewmodel.factory.SplashViewModelFactory
import com.kimstik.appselect.util.AppApplication
import com.kimstik.appselect.util.BUNDLE_KEY
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {

    @Inject lateinit var vmFactory: SplashViewModelFactory
    private lateinit var vm: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        (AppApplication.INSTANCE as AppApplication).appComponent.injectSplashViewModel(this)
        vm = ViewModelProvider(this, vmFactory)[SplashViewModel::class.java]

        lifecycleScope.launchWhenStarted {
            vm.item.collect {
                navigateToMainActivity(it)
            }
        }
    }

    private fun navigateToMainActivity(item: String?) {
        if(item != null) {
            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra(BUNDLE_KEY, item)
                startActivity(this)
            }
            finish()
        }
    }
}