package com.wenger.natifetask1.ui.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.model.Item

class ListViewModel(
    private val prefs: Prefs
) : ViewModel() {

    private val _itemList = MutableLiveData<ArrayList<Item>>()
    val itemList: LiveData<ArrayList<Item>> = _itemList

    fun saveItemId(id: Int) {
        prefs.setItemId(id)
    }

    fun getItemList() {
        val list = ItemList.getList()
        _itemList.value = list
    }

}