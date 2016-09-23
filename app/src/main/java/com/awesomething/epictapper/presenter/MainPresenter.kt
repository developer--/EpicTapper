package com.awesomething.epictapper.presenter

import android.content.Context
import com.awesomething.epictapper.model.data.MyData

/**
 * Created by Jemo on 9/23/16.
 */
class MainPresenter {
    var data : MyData
    constructor(context: Context){
        data = MyData(context)
    }

    fun save(value : String) {
        data.saveData(MyData.ANDROID,value)
    }

    fun getValue(key : String) = data.getStatistic(key)
}