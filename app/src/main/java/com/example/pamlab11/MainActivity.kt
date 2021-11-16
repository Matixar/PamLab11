package com.example.pamlab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View

import android.widget.TextView

import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<EditText>(R.id.ip1).filters = arrayOf(InputFilterMinMax(0, 255))
        findViewById<EditText>(R.id.ip2).filters = arrayOf(InputFilterMinMax(0, 255))
        findViewById<EditText>(R.id.ip3).filters = arrayOf(InputFilterMinMax(0, 255))
        findViewById<EditText>(R.id.ip4).filters = arrayOf(InputFilterMinMax(0, 255))
    }

    fun buttonPress(view: View?) {
        getIPInfo()
    }

    private fun getIP(): String {
        val e1 = findViewById<View>(R.id.ip1) as EditText
        val e2 = findViewById<View>(R.id.ip2) as EditText
        val e3 = findViewById<View>(R.id.ip3) as EditText
        val e4 = findViewById<View>(R.id.ip4) as EditText
        if(e1.text.toString().toInt() > 255) e1.setText("255")
        if(e2.text.toString().toInt() > 255) e2.setText("255")
        if(e3.text.toString().toInt() > 255) e3.setText("255")
        if(e4.text.toString().toInt() > 255) e4.setText("255")
        val ip = e1.text.toString() + "." + e2.text.toString() + "." +
                e3.text.toString() + "." + e4.text.toString()
        Log.i("-->", ip)
        return ip
    }

    private fun printInfo(info: IPInfo?) {
        val textView = findViewById<View>(R.id.textView) as TextView
        val s: String
        s = if (info == null) "Faild" else {
            """
     ip: ${info.getIp()}
     hostname: ${info.getHostname()}
     city: ${info.getCity()}
     region: ${info.getRegion()}
     country: ${info.getCountry()}
     loc: ${info.getLoc()}
     org: ${info.getOrg()}
     postal: ${info.getPostal()}
     timezone: ${info.getTimezone()}
     readme: ${info.getReadme()}
     """.trimIndent()
        }
        textView.text = s
    }

    private fun getIPInfo() {
        val apiInterface: ApiInterface =
            ServiceGenerator.createService<ApiInterface>(ApiInterface::class.java, getIP())
        val call: Call<IPInfo?>? = apiInterface.getIPInfo()
        call?.enqueue(object : Callback<IPInfo?> {
            override fun onResponse(call: Call<IPInfo?>?, response: Response<IPInfo?>) {
                printInfo(response.body())
            }

            override fun onFailure(call: Call<IPInfo?>?, t: Throwable?) {
                printInfo(null)
            }
        })
    }
}