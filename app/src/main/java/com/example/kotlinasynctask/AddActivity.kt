package com.example.kotlinasynctask

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {
    var num1:Int = 0
    var num2:Int = 0
    var num3:Int = 0
    var res:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var intent:Intent? = null
        num1 = getIntent().getIntExtra("num1",0)
        num2 = getIntent().getIntExtra("num2",0)
        num3 = getIntent().getIntExtra("num3",0)
        res = num1+num2+num3
        Log.i("add",res.toString())

        if (intent != null) {
            //intent = Intent(this,MainActivity::class.java)
            intent.putExtra("result",res.toString())
        }
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
