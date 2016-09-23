package com.awesomething.epictapper.model.data

import android.content.Context
import com.awesomething.epictapper.utils.save

/**
 * Created by Jemo on 9/23/16.
 */
class MyData {
    lateinit var context : Context
    constructor(context: Context){
        this.context = context
    }

    companion object {
        val prefName : String = "MY_PREF"
        val ANDROID : String = "ANDROID"
        val iOS : String = "iOS"
        fun getPref(context: Context) = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
    }
    fun getStatistic(key : String) = getPref(context).getString(key,"0")
    fun saveData(key: String, value: String) = getPref(context).edit().save(key,value)

}