package com.example.mad_terminal

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat

class Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ContextCompat.startActivity(context,intent, null)
    }
}