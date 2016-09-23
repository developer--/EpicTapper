package com.awesomething.epictapper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.awesomething.epictapper.model.data.MyData
import com.awesomething.epictapper.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        initUI()
        attachListeners()
    }

    private fun attachListeners() {
        androidButton.setOnClickListener(this)
    }

    private fun initUI(){
        val android = presenter.getValue(MyData.ANDROID)
        val iOS = presenter.getValue(MyData.iOS)

        androidText.text = android.toString()
        appleText.text = iOS.toString()
    }


    override fun onClick(v: View?) {
        val android = androidText.text.toString().toLong() + 1
        androidText.text = android.toString()
        presenter.save(android.toString())
    }
}
