package com.example.myapplication.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<VH: BaseViewHolder<Entity>, Entity> : RecyclerView.Adapter<VH>() {
    private val list = mutableListOf<Entity>()
    protected lateinit var onClick: () -> Unit

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener { onClick() }
    }

    override fun getItemCount(): Int = list.size

    fun addItems(list: MutableList<Entity>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnCLick (onClick: () -> Unit) {
        this.onClick = onClick
    }

    fun addItem(item: Entity) {
        list.add(item)
        notifyDataSetChanged()
    }
}