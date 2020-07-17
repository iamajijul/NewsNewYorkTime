package com.ajijul.newsnewyorktimes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajijul.newsnewyorktimes.R
import com.ajijul.newsnewyorktimes.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}