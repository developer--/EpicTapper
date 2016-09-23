package com.awesomething.epictapper.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.awesomething.epictapper.R
import com.awesomething.epictapper.model.data.MyData
import com.awesomething.epictapper.presenter.MainPresenter
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

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



    fun scaleView() {
        ViewAnimator
                .animate(androidButton)
                .scale(1.05f,1f)
                .duration(150)
                .start()
    }

    override fun onClick(v: View?) {
        scaleView()

        val android = androidText.text.toString().toLong() + 1
        androidText.text = android.toString()
        presenter.save(android.toString())
    }
}
