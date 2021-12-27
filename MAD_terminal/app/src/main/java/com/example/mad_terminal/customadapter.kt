package com.example.recyleview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.mad_terminal.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact.view.*
import org.json.JSONException

class customadapter : RecyclerView.Adapter<viewholder>() {
    val items = ArrayList<Any>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val linflater = LayoutInflater.from(parent?.context)
        val newinf = linflater.inflate(R.layout.contact,parent,false)
        return viewholder(newinf)

    }
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val titlev = items.get(position)
        holder.v.c_title.text = titlev.toString()
        holder.v.c_qty.text = titlev.toString()
    }

}
class  viewholder(val v:View):RecyclerView.ViewHolder(v){

}

