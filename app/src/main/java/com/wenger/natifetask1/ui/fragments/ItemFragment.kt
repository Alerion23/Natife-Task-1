package com.wenger.natifetask1.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.R
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item) {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)
        showItemDetails()
        getIdAndLog()
    }

    private fun showItemDetails() {
        val item = ItemList.getItemById(args.itemArg)
        val id = item?.id
        val name = item?.name
        val description = item?.description
        binding?.apply {
            itemIdTitle.text = getString(R.string.id, id)
            itemNameTitle.text = getString(R.string.name, name)
            itemDescriptionTitle.text = getString(R.string.description, description)
        }
    }

    private fun getIdAndLog() {
        val prefsId = Prefs(requireContext()).getItemId()
        Log.i(TAG, "Id = $prefsId")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val TAG = "Item id"
    }
}