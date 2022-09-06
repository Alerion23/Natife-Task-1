package com.wenger.natifetask1.ui.fragments.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.wenger.natifetask1.R
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.data.interactors.GetItemByIdImpl
import com.wenger.natifetask1.data.interactors.GetItemIdImpl
import com.wenger.natifetask1.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item), ItemView {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()
    private val presenter: ItemPresenter by lazy {
        val prefs = Prefs(requireContext())
        val reducer = ItemReducer(args.itemArg)
        val getItemDetails = GetItemByIdImpl()
        val getItemId = GetItemIdImpl(prefs)
        ItemPresenterImpl(this, getItemId, getItemDetails, reducer)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)
        logItemId()
        getItemDetails()
    }

    override fun render(states: ItemViewState) {
        val item = states.item
        if (item != null) {
            val id = item.id
            val name = item.name
            val description = item.description
            showItemDetails(id, name, description)

        }
    }

    private fun getItemDetails() {
        presenter.getItemDetails()
    }

    private fun logItemId() {
        presenter.getIdAndLog()
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