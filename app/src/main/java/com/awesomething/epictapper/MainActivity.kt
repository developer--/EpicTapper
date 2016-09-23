package com.awesomething.epictapper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.awesomething.epictapper.model.data.MyData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var data : MyData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data = MyData(this)

        initUI()
        attachListeners()
    }

    private fun attachListeners() {
        androidButton.setOnClickListener {
            val android = androidText.text.toString().toLong() + 1
            data.saveData(MyData.ANDROID, android.toString())
            androidText.text = android.toString()
        }
    }

    private fun initUI(){
        val android = data.getStatistic(MyData.ANDROID)
        val iOS = data.getStatistic(MyData.iOS)
        androidText.text = android.toString()
    }

}
