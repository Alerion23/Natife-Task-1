package com.wenger.natifetask1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wenger.natifetask1.*
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private var binding: FragmentListBinding? = null
    private val itemAdapter: ItemAdapter by lazy {
        ItemAdapter(clickListener)
    }

    private val clickListener = object : OnItemClickListener {

        val prefs: Prefs by lazy {
            Prefs(requireContext())
        }

        override fun onItemClick(id: Int) {
            prefs.setItemId(id)
            val directions = ListFragmentDirections.goToItemFragment(id)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setupView()
        showItemList()
    }

    private fun showItemList() {
        val newItemList = ItemList.getList()
        itemAdapter.submitList(newItemList)
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