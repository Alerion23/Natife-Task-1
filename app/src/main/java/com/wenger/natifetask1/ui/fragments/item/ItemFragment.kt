package com.wenger.natifetask1.ui.fragments.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.wenger.natifetask1.R
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.data.interactors.GetItemByIdImpl
import com.wenger.natifetask1.data.interactors.GetItemByIdInteractor
import com.wenger.natifetask1.data.interactors.GetItemIdImpl
import com.wenger.natifetask1.data.interactors.GetItemIdInteractor
import com.wenger.natifetask1.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item), ItemView {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()
    private val presenter: ItemPresenter by lazy {
        val prefs = Prefs(requireContext())
        val getItemDetails: GetItemByIdInteractor = GetItemByIdImpl()
        val getItemId: GetItemIdInteractor = GetItemIdImpl(prefs)
        ItemPresenterImpl(this, getItemId, getItemDetails)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)
        logItemId()
        getItemDetails()
    }

    override fun render(states: ItemViewStates) {
        when (states) {
            is ItemViewStates.DisplayedItemDetails -> {
                showItemDetails(states.id, states.name, states.description)
            }
        }
    }

    private fun getItemDetails() {
        presenter.obtainEvent(ItemEvent.GetItemDetails(args.itemArg))
    }

    private fun logItemId() {
        presenter.obtainEvent(ItemEvent.GetItemIdAndLog)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun showItemDetails(id: Int, name: String, description: String) {
        binding?.apply {
            itemIdTitle.text = getString(R.string.id, id)
            itemNameTitle.text = getString(R.string.name, name)
            itemDescriptionTitle.text = getString(R.string.description, description)
        }
    }

    companion object {
        const val TAG = "Item id"
    }
}