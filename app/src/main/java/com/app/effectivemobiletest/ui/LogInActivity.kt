package com.app.effectivemobiletest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.effectivemobiletest.R
import com.app.effectivemobiletest.databinding.ActivityLogInBinding
import com.app.effectivemobiletest.databinding.ActivityMainBinding

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityLogInBinding = DataBindingUtil.setContentView(this,R.layout.activity_log_in)



    }
}