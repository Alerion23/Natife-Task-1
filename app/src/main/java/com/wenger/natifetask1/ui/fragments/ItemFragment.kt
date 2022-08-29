package com.wenger.natifetask1.ui.fragments

import android.annotation.SuppressLint
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

    @SuppressLint("SetTextI18n")
    private fun showItemDetails() {
        val id = getString(R.string.id)
        val name = getString(R.string.name)
        val description = getString(R.string.description)
        binding?.apply {
            itemIdTitle.text = id + " " + args.itemArg?.id.toString()
            itemNameTitle.text = name + " " + args.itemArg?.name
            itemDescriptionTitle.text = description + " " + args.itemArg?.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}