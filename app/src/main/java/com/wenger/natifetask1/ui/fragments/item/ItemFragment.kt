package com.wenger.natifetask1.ui.fragments.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.wenger.natifetask1.R
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item), ItemView {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()
    private val prefs: Prefs by lazy {
        Prefs(requireContext())
    }
    private val presenter: ItemPresenter by lazy {
        ItemPresenterImpl(this, prefs)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)
        logItemId()
        getItemDetails()
    }

    private fun getItemDetails() {
        presenter.getItemDetails(args.itemArg)
    }

    private fun logItemId() {
        presenter.getIdAndLog()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun showItemDetails(id: Int?, name: String?, description: String?) {
        if (id != null && name != null && description != null) {
            binding?.apply {
                itemIdTitle.text = getString(R.string.id, id)
                itemNameTitle.text = getString(R.string.name, name)
                itemDescriptionTitle.text = getString(R.string.description, description)
            }
        }
    }

    companion object {
        const val TAG = "Item id"
    }
}