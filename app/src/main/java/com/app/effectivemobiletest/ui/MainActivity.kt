package com.app.effectivemobiletest.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.effectivemobiletest.R
import com.app.effectivemobiletest.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val uiScope = CoroutineScope(Dispatchers.Main + Job())
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }

        toMainActivity()
    }

    override fun onDestroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
        }

        super.onDestroy()
    }


    private fun toMainActivity() {
        ioScope.launch {
            delay(3000)
            uiScope.launch {
                startActivity(Intent(this@MainActivity, SingInActivity::class.java))
                finish()
            }
        }
    }
}