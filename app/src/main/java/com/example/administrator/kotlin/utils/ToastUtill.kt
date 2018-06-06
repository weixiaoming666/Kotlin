package com.example.administrator.kotlin.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.administrator.kotlin.R

/**
 * Created by Administrator on 2018/4/18.
 */

object  ToastUtill {
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showTextdialog(context: Context, msg: String) {
        // 创建对话框构建器
        val builder = AlertDialog.Builder(context)
        // 获取布局
        val view2 = View.inflate(context, R.layout.showtext, null)
        // 获取布局中的控件
        val username = view2.findViewById(R.id.tv_alterdialog_showtext) as TextView
        val button = view2.findViewById(R.id.BT_alterdialog_showtext) as Button
        username.text = msg
        // 设置参数
        builder.setTitle("认真看").setIcon(R.mipmap.ic_launcher_round)
                .setView(view2)
        // 创建对话框
        val alertDialog = builder.create()
        button.setOnClickListener {
            // TODO Auto-generated method stub
            alertDialog.dismiss()// 对话框消失
        }
        alertDialog.show()
    }

    fun showChosedialog(context: Context, list: List<String>) {
        // 创建对话框构建器
        val builder = AlertDialog.Builder(context)
        // 获取布局
        val view2 = View.inflate(context, R.layout.showtext, null) as LinearLayout
        // 获取布局中的控件
        val username = view2.findViewById(R.id.tv_alterdialog_showtext) as TextView
        val button = view2.findViewById(R.id.BT_alterdialog_showtext) as Button
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        button.text = "选择ok"
        button.visibility = View.GONE
        // 设置参数
        builder.setTitle("请选择").setIcon(R.mipmap.ic_launcher_round)
                .setView(view2)
        // 创建对话框
        val alertDialog = builder.create()
        button.setOnClickListener {
            // TODO Auto-generated method stub
            alertDialog.dismiss()// 对话框消失
        }
        showSelect(context, list, view2, alertDialog)
        alertDialog.show()
    }

    private fun showSelect(context: Context, empty: List<String>, view2: LinearLayout, alertDialog: AlertDialog) {
        if (empty.isEmpty()) {
            ToastUtill.showToast(context, "没有选项")
            return
        } else {
            for (i in empty.indices) {
                val item = LinearLayout.inflate(context, R.layout.item_select, null) as LinearLayout
                val radioButton = item.findViewById(R.id.rb_select) as RadioButton
                radioButton.setText(empty[i].toString())
                radioButton.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
                    if (b) {
                        ToastUtill.showToast(context, compoundButton.text.toString())
                        alertDialog.dismiss()
                    }
                })
                view2.addView(item)
            }
        }

    }
}
