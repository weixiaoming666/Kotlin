package com.example.administrator.kotlin
/*
* 与Java定义包名一样，在源文件的开头定义包名：
* 包名和文件夹路径可以不一致：源文件可以放在项目的任意位置。
* */
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ListViewCompat
import android.view.View
import com.example.administrator.kotlin.activity.KotlinDemo1
import com.example.administrator.kotlin.utils.ToastUtill
import com.example.administrator.kotlin.utils.Utill


//学习第一步 Settings->Plugins->Browse Repositories->搜索kotlin  安卓ojbk 自动同步和选择版本 ojbk
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //沉浸式
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN//隐藏状态栏
//        supportActionBar!!.hide();//隐藏actionbar
        setListenter()
    }

    private fun setListenter(){
        var listView: ListViewCompat = findViewById(R.id.lv) as ListViewCompat ;
        listView.setOnItemClickListener { adapterView, view, i, l ->

            when(i){
                1-> startActivity(Intent(this@MainActivity, KotlinDemo1::class.java))
                2-> Utill.jump2NewAty(this@MainActivity,KotlinDemo1::class.java)
            }
            ToastUtill.showToast(this, i.toString())
        }
    }


    //    定义函数(Defining functions)与Java定义函数的区别在于：
// Kotlin在定义函数的时候要加个fun关键词，函数的返回值前后不同，Java的在前面，RU:
    private fun getA(): String {
        return "a"
    }

    private fun getWo(a: Int, b: Int): Int {
        return a + b
    }

    //    如果一个函数只有一个并且是表达式函数体并且是返回类型自动推断的话，可以直接这样写
    // 这里的函数没有写返回值，因为Kotlin会自动判断返回值类型
    fun getResult(a: Int, b: Int) = a + b

    fun getResult(a: Int, b: Int, c: Int) = a + b + c


    //    如果函数返回一个无意义的值，相当于Java的void，则可以这样写
    fun getResultUnit(a: Int, b: Int): Unit {
        print(a + b)
    }

    //    Uint 的返回类型可以省略
    fun getResultUnit1(a: Int, b: Int) {
        print(a + b)
    }


//    定义局部变量(Defining local variables)
/*    Kotlin声明变量与Java声明变量有些不一样，Java变量类型在前，变量名在后，而Kotlin则相反，变量名在前，变量类型在后，
    中间加:(冒号)，并且Kotlin可以自动判断变量的类型。
*/
  fun demo(){
//    声明局部常量（常量使用val关键字）
    val a: Int = 1
    val b = 1   // 自动判断出Int类型
    val c: Int  // 当没有初始化值的时候要声明类型，全局变量不能这样写
    c = 1       // 赋值

//    声明变量（变量使用var关键字）
    var x = 5 // 自动推断出Int类型
    x += 1
}


//    注释(Comments)
//    Kotlin的注释与Java一样， 支持单行注释和块注释。

//    使用字符串模版(Using string templates)
//    使用${变量}，如变量为args: Array<String>"，使用的时候可以这样写
fun main(args: Array<String>) {
    if (args.size == 0) return
    print("First argument: ${args[0]}")
    //    而不用再去用加号加起来，gradle里面也是支持的

}
//    使用条件表达式(Using conditional expressions)
    fun max(a: Int,b: Int):Int{
    if (a>b) {
        return a
    } else{
        return b
    }
}
    fun max1(a: Int, b: Int) = if (a > b) a else b

//    使用可空变量和空置检查(Using nullable values and checking for null)
    fun getnull(a: Int, b: Int): Int? { // 设置函数返回类型可空 多一个问号
        print(a + b)
        return null
    }

//    使用类型检查和自动转换(Using type checks and automatic casts)
//    is运算符是检查一个表达式是否是某个类型的实例，如果为不可变局部变量或属性进行类型检查，则无需显式转换
     fun getStringLength(obj:Any) :Int?{
        if (obj is MainActivity) {//自动判断类型
            // `obj`在这个分支中自动转换为`String`类型
            return 9
        }
        // `obj`仍然是`Any`类型
        return null
    }
    fun getStringLength1(obj:Any) :Int?{//简单写法
        if (obj !is String) return null
        // `obj`在这个分支中自动转换为`String`类型
        return obj.length
    }
    fun getStringLength2(obj:Any) :Int?{  //private 修饰词没啥用
        // `obj` 自动转换成`String`类型，并且在&&后面生效
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

//    使用for循环(Using a for loop)
//    与Java相比，Kotlin使用for循环要更加的简洁
    fun mainFor(args: Array<String>) {
    for (arg in args) { // in操作符可以判断是否arg是否在args里面
        print(arg)
    }
    for (i in args.indices) {//简单写法
        print(args[i])
    }
//    使用while循环(Using a while loop)
    var i = 0
    while (i < args.size) {
        print(args[i++])
    }


}
    fun cases(obj: Any) {
//        when表达式就相当于Java的switch表达式，省去了case和break，并且支持各种类型。
        when (obj) {
            1 -> print("One") //如果obj的值为1
            "Hello" -> print("Greeting") // 如果obj的值为hello
            is Long -> print("Long") // 如果obj的类型是Long类型
            !is String -> print("Not a string") // 如果obj的类型不属于String类型
            else -> print("Unknown") // 默认，相当于switch的default
        }


//        使用in运算符检查数字是否在范围内
        val x = 0
        val y = 5
        if (x in 1..y - 1) { //1..y-1表示1到y-1的范围
            print("OK")
        }
        for (i in 1..100) {
        }  //  1到100范围
        for (i in 1 until 100) {
        } // 半开范围，不包括100，相当于[1,100)
        for (x in 2..10 step 2) {
        } // 每次夸2，内容为2,4,6,8,10
        for (x in 10 downTo 1) {
        } // 返序
        if (x in 1..10) {
        }
//        if (x !in 0..array.lastIndex) {
//            print("Out")
//        }

//        循环输出一个集合里面的值或者判断集合里面是否包含某个变量
        // 将会调用nemes.contains(name)方法
        val names:Array<Int> = emptyArray()
        names[0] = 1
        for (name in names) {
            println(name)
        }

    }


    protected fun setImmerseLayout(view: View) {// view为标题栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_FULLSCREEN
            decorView.systemUiVisibility = option
            val actionBar = supportActionBar
            actionBar!!.hide()

        }
    }

    // 沉浸式体验 本质上只是对decorView 的  UI flag 修改
//    https://blog.csdn.net/guolin_blog/article/details/51763825   学习链接
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

}
