package com.wenger.natifetask1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.wenger.natifetask1.R
import com.wenger.natifetask1.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item) {

    private var binding: FragmentItemBinding? = null
    private val args: ItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)
        showItemDetails()
    }

    private fun showItemDetails() {
        binding?.apply {
            itemId.text = args.itemArg?.id.toString()
            itemName.text = args.itemArg?.name
            itemDescription.text = args.itemArg?.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}