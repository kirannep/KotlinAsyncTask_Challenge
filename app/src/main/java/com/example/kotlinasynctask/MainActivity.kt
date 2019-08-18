package com.example.kotlinasynctask

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
     var calc_result: String = ""

    override fun onClick(view: View?) {
        var intent:Intent?=null
        when (view!!.id){
            R.id.button ->{
                var num1 = et_num1.text.toString().toInt()
                var num2 = et_num2.text.toString().toInt()
                var num3 = et_num3.text.toString().toInt()
                intent = Intent(this,AddActivity::class.java)
                intent.putExtra("num1",num1)
                intent.putExtra("num2",num2)
                intent.putExtra("num3",num3)
            }
        }
        MyAsync(intent).execute()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                if (data != null) {
                    textView2.setText(data.getStringExtra("result"))
                }
                    Log.i("hey",calc_result)
                    //textView2.text = calc_result

            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
    }

    inner class MyAsync(var intent: Intent?): AsyncTask<Void, Void, String>() {


        override fun onPreExecute() {
            pgBar.visibility = View.VISIBLE
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): String {
            startActivityForResult(intent,1)
            return calc_result
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            pgBar.visibility = View.GONE
            textView2.text = result
        }
    }
}


