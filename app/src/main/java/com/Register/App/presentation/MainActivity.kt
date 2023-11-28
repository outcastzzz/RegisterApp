package com.Register.App.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Register.App.R

class MainActivity : AppCompatActivity() {

    private val component by lazy {
        (application as AuthApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}