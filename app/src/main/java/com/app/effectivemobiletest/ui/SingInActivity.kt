package com.app.effectivemobiletest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.effectivemobiletest.R
import com.app.effectivemobiletest.databinding.ActivitySingInBinding

class SingInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySingInBinding = DataBindingUtil.setContentView(this,R.layout.activity_sing_in)




    }
}