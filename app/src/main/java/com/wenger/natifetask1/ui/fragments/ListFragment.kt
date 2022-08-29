package com.wenger.natifetask1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wenger.natifetask1.IOnGifsClickListener
import com.wenger.natifetask1.ItemAdapter
import com.wenger.natifetask1.R
import com.wenger.natifetask1.databinding.FragmentListBinding
import com.wenger.natifetask1.model.Item

class ListFragment : Fragment(R.layout.fragment_list) {

    private var binding: FragmentListBinding? = null
    private var itemAdapter: ItemAdapter? = null

    private val clickListener = object : IOnGifsClickListener {
        override fun onItemClick(item: Item) {
            val directions = ListFragmentDirections.goToItemFragment(item)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        itemAdapter = ItemAdapter(clickListener)
        setupView()
        createItemList()
    }

    private fun createItemList() {
        val itemList = arrayListOf<Item>()
        for (i in 0..19) {
            val name: String = getRandomString(7)
            val description: String = getRandomString(20)
            val item = Item(i, name, description)
            itemList.add(item)
        }
        itemAdapter?.submitList(itemList)
    }

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    private fun setupView() {
        binding?.apply {
            itemRecycler.layoutManager =
                LinearLayoutManager(this@ListFragment.context, RecyclerView.VERTICAL, false)
            itemRecycler.adapter = itemAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}