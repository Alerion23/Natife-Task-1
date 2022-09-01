package com.wenger.natifetask1.ui.fragments.item

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.R
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.databinding.FragmentItemBinding
import com.wenger.natifetask1.ui.fragments.list.ListViewModel
import com.wenger.natifetask1.ui.fragments.list.ListViewModelFactory
import com.wenger.natifetask1.utils.ViewState

class ItemFragment : Fragment(R.layout.fragment_item) {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()
    private val viewModel: ItemViewModel by viewModels {
        val prefs = Prefs(requireContext())
        ItemViewModelFactory(prefs)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)
        viewModel.getItemDetails(args.itemArg)
        viewModel.getIdAndLog()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.selectedItem.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    val id = it.data.id
                    val name = it.data.name
                    val description = it.data.description
                    binding?.apply {
                        itemIdTitle.text = getString(R.string.id, id)
                        itemNameTitle.text = getString(R.string.name, name)
                        itemDescriptionTitle.text = getString(R.string.description, description)
                    }
                }
                is ViewState.Fail -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG = "Item id"
    }
}