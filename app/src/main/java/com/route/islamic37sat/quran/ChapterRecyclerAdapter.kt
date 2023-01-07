package com.route.islamic37sat.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37sat.R

class ChapterRecyclerAdapter(val items: List<String>) :
    RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {
    //    val items:List<String>
//    constructor(items:List<String>):super(){
//        this.items=items;
//    }
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.title.setText(items[position])
        holder.title.text = items[position]
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, items[position])
            }
        }
    }

    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView

        init {
            title = itemView.findViewById(R.id.title)
        }
    }
}