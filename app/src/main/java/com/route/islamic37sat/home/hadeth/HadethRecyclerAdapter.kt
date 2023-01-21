package com.route.islamic37sat.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37sat.databinding.ItemHadethBinding

class HadethRecyclerAdapter(val items: List<Hadeth>) :
    RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text = items[position].title
    }

    override fun getItemCount(): Int = items.size
    class ViewHolder(val viewBinding: ItemHadethBinding) : RecyclerView.ViewHolder(viewBinding.root)
}