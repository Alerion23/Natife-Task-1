package com.wenger.natifetask1.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
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
    private val viewModel: ListViewModel by viewModels {
        val prefs = Prefs(requireContext())
        ListViewModelFactory(prefs)
    }

    private val clickListener = object : OnItemClickListener {

        override fun onItemClick(id: Int) {
            viewModel.saveItemId(id)
            val directions = ListFragmentDirections.goToItemFragment(id)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setupView()
        viewModel.getItemList()
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.itemList.observe(viewLifecycleOwner) {
            itemAdapter.submitList(it)
        }
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