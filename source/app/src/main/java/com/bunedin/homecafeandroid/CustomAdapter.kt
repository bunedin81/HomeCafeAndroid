package com.bunedin.homecafeandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<MainActivity.ListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData.get(position)
        holder.setListData(data)
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleTextView = itemView.findViewById<TextView>(R.id.list_item_title)
    var priceTextView = itemView.findViewById<TextView>(R.id.list_item_price)
    fun setListData(listData: MainActivity.ListData){
        titleTextView.text = "${listData.title}"
        priceTextView.text = "${listData.price}"
    }
}
