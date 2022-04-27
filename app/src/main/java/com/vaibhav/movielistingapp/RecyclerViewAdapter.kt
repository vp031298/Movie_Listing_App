package com.vaibhav.movielistingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var data : MovieResponse) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview = itemView.findViewById<TextView>(R.id.tvName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflator : LayoutInflater = LayoutInflater.from(parent.context)
        var view : View = inflator.inflate(R.layout.row,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var text : String? = data!!.docs[position].name
        holder.textview.setText(text)
    }

    override fun getItemCount(): Int {
        return data!!.total!!
    }

}

