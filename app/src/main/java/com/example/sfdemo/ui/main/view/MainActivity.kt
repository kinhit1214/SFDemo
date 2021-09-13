package com.example.sfdemo.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sfdemo.R
import com.example.sfdemo.R.id.conteiner_fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(conteiner_fragment, MainFragment.newInstance())
                .commitNow()
        }
    }
}