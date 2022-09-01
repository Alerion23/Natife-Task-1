package com.wenger.natifetask1.ui.fragments.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wenger.natifetask1.data.Prefs

class ListViewModelFactory(
    private val prefs: Prefs
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == ListViewModel::class.java) {
            return ListViewModel(prefs) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")

    }
}