package com.awesomething.epictapper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachListeners()
    }

    private fun attachListeners() {
        androidButton.setOnClickListener { androidText.text = (androidText.text.toString().toLong() + 1).toString() }
    }


}
