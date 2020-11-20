package com.bojanvilic.cccandroidtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bojanvilic.cccandroidtest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
    }
}