package com.awesomething.epictapper.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Jemo on 9/23/16.
 */
inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.Editor.setVal(pair: Pair<String, String>) =
        putString(pair.first,pair.second)

fun SharedPreferences.Editor.save(key : String, value : String) = putString(key,value).apply()
