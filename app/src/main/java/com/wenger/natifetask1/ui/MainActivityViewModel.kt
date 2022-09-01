package com.wenger.natifetask1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.utils.ViewState

class MainActivityViewModel : ViewModel() {

    private val _itemIdState = MutableLiveData<ViewState<Int>>()
    val itemIdState: LiveData<ViewState<Int>> = _itemIdState

    fun createItemList() {
        if (ItemList.getList().size != 20) {
            ItemList.createList()
        }
    }

    fun checkLastItemId(id: Int) {
        if (id > -1) {
            _itemIdState.value = ViewState.Success(id)
        }
    }

}