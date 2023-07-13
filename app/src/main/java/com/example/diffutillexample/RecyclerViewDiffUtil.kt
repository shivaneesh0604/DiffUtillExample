package com.example.diffutillexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDiffUtil: RecyclerView.Adapter<RecyclerViewDiffUtil.RecyclerViewViewHolder>() {

    private var oldListItems = emptyList<DiffUtilItem>()

    inner class RecyclerViewViewHolder(view:View):RecyclerView.ViewHolder(view){
        val id = view.findViewById<TextView>(R.id.idtv)
        val name = view.findViewById<TextView>(R.id.idname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        return RecyclerViewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rvitem, parent, false))
    }

    override fun getItemCount(): Int {
        return oldListItems.size
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val item = oldListItems[position]
        holder.id.text = item.name
        holder.name.text = item.id.toString()
    }

    fun setData(newList: List<DiffUtilItem>){
        Log.e("check","check newlist send is $newList")
        val diffUtil = DiffUtillClass(oldListItems,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldListItems = newList
        diffResult.dispatchUpdatesTo(this)
        Log.e("check","check oldlist updated is $oldListItems")
    }
}