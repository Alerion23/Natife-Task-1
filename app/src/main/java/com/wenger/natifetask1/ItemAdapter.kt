package com.wenger.natifetask1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wenger.natifetask1.model.Item

class ItemAdapter(
    private val clickListener: IOnGifsClickListener
) : ListAdapter<Item, ItemAdapter.MyViewHolder>(ItemDiffCallBack()) {

    class ItemDiffCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.items_list, parent, false
        )
        return MyViewHolder(itemView, clickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MyViewHolder(
        itemView: View,
        private val clickListener: IOnGifsClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.name)

        fun onBind(currentItem: Item) {
            name.text = currentItem.name
            itemView.setOnClickListener {
                clickListener.onItemClick(currentItem)
            }
        }

    }

}
