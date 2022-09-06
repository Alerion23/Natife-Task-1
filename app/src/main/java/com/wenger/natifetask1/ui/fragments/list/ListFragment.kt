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
        val reducer = ListReducer()
        val saveItemIdInteractor = SaveItemIdImpl(prefs)
        val getItemListInteractor = GetItemListImpl()
        ListPresenterImpl(this, saveItemIdInteractor, getItemListInteractor, reducer)
    }

    private val clickListener = object : OnItemClickListener {

        override fun onItemClick(id: Int) {
            presenter.saveItemId(id)
            val directions = ListFragmentDirections.goToItemFragment(id)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setupView()
        presenter.getNewList()
    }

    override fun render(state: ListViewState) {
        showItemList(state.list)
    }

    private fun setupView() {
        binding?.apply {
            itemRecycler.layoutManager =
                LinearLayoutManager(context)
            itemRecycler.adapter = itemAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun showItemList(list: List<Item>) {
        itemAdapter.submitList(list)
    }
}