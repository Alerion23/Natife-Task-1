package com.wenger.natifetask1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wenger.natifetask1.databinding.ItemsListBinding
import com.wenger.natifetask1.model.Item

class ItemAdapter(
    private val clickListener: OnItemClickListener
) : ListAdapter<Item, ItemAdapter.MyViewHolder>(ItemDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemsListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(clickListener, binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ItemDiffCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name && oldItem.description == newItem.description
        }
    }

    class MyViewHolder(
        private val clickListener: OnItemClickListener,
        private val binding: ItemsListBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun onBind(currentItem: Item) {
            binding.name.text = currentItem.name
            itemView.setOnClickListener {
                clickListener.onItemClick(currentItem.id)
            }
        }
    }

}
