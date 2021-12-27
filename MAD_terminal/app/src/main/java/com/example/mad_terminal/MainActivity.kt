package com.example.mad_terminal

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.recyleview.customadapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact.*
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    private var requestQueue: RequestQueue? = null

    val items = ArrayList<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        jsonParse()
        requestQueue = Volley.newRequestQueue(this)
        recycler.layoutManager= LinearLayoutManager(this)
        recycler.adapter= customadapter()
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS) !=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.RECEIVE_SMS,android.Manifest.permission.SEND_SMS),
                111
            )
        }

        c_buy_btn.setOnClickListener{
            var sms = SmsManager.getDefault()
            sms.sendTextMessage("1234","ME","you bought item",null,null)
        }
        textView3.text = items.toString()
    }

    private fun jsonParse() {

        val url = "https://run.mocky.io/v3/0085e3ac-c7d6-4a93-ba92-925f65be6fb3"
        val request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
                response ->try {
            Log.d("Respronse", response.toString() )
            val jsonArray = response.getJSONArray("")
            for (i in 0 until jsonArray.length()) {
                val employee = jsonArray.getJSONObject(i)
                val title = employee.getString("title")
                val qty = employee.getInt("quantity")
                val p = java.util.ArrayList<String>(2)
                p[0] = title
                p[1] = qty.toString()
                items.add(p)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }


    override fun onStart() {
        super.onStart()
        Log.d("Onstart", "i am started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy", "i am Destroyed")
    }
}