package com.wenger.natifetask1.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wenger.natifetask1.*
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.data.interactors.*
import com.wenger.natifetask1.databinding.FragmentListBinding
import com.wenger.natifetask1.model.Item

class ListFragment : Fragment(R.layout.fragment_list), ListFragmentView {

    private var binding: FragmentListBinding? = null
    private val itemAdapter: ItemAdapter by lazy {
        ItemAdapter(clickListener)
    }
    private val presenter: ListPresenter by lazy {
        val prefs = Prefs(requireContext())
        val saveItemIdInteractor: SaveItemIdInteractor = SaveItemIdImpl(prefs)
        val getItemListInteractor: GetItemListInteractor = GetItemListImpl()
        ListPresenterImpl(this, saveItemIdInteractor, getItemListInteractor)
    }

    private val clickListener = object : OnItemClickListener {

        override fun onItemClick(id: Int) {
            presenter.obtainEvent(ListEvent.SaveItemId(id))
            val directions = ListFragmentDirections.goToItemFragment(id)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setupView()
        presenter.obtainEvent(ListEvent.GetList)
    }

    override fun render(states: ListViewStates) {
        when (states) {
            is ListViewStates.DisplayedItemList -> {
                showItemList(states.list)
            }
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

    private fun showItemList(list: ArrayList<Item>) {
        itemAdapter.submitList(list)
    }
}