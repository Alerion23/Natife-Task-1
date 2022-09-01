package com.wenger.natifetask1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == MainActivityViewModel::class.java) {
            return MainActivityViewModel() as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}