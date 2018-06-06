package com.example.administrator.kotlin.utils

import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by Administrator on 2018/4/18.
 */

object Utill {
    fun jump2NewAty(context: Context, s: Class<*>) {
        val intent = Intent(context, s)
        context.startActivity(intent)
    }

    fun myLogErr(tag: String, msg: String) {
        Log.e(tag, msg)
    }
}
