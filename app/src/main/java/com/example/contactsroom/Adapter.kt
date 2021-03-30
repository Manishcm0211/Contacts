package com.example.contactsroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var arrayList: List<User>, private val clickListener: OnContactItemClickListener) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(view : View, private val onClickListener:  OnContactItemClickListener ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textView1: TextView = view.findViewById(R.id.text_view_1)
        val textView2: TextView = view.findViewById(R.id.text_view_2)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onClickListener.onContactClick(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(itemView,clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val arrayList = arrayList[position]
        holder.textView1.text = arrayList.ContactName
        holder.textView2.text = arrayList.ContactNumber
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    interface OnContactItemClickListener {
        fun onContactClick( position: Int)
    }

}