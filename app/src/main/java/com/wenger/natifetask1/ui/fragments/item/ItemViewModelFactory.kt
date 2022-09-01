package com.wenger.natifetask1.ui.fragments.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wenger.natifetask1.data.Prefs

class ItemViewModelFactory(
    private val prefs: Prefs
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == ItemViewModel::class.java) {
            return ItemViewModel(prefs) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}