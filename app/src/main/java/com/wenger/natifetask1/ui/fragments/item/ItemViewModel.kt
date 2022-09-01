package com.wenger.natifetask1.ui.fragments.item

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.model.Item
import com.wenger.natifetask1.utils.ViewState

class ItemViewModel(
    private val prefs: Prefs
) : ViewModel() {

    private val _selectedItem = MutableLiveData<ViewState<Item>>()
    val selectedItem: LiveData<ViewState<Item>> = _selectedItem

    fun getItemDetails(id: Int) {
        val item = ItemList.getItemById(id)
        if (item != null) {
            _selectedItem.value = ViewState.Success(item)
        } else {
            _selectedItem.value = ViewState.Fail("Something went wrong")
        }
    }

    fun getIdAndLog() {
        val prefsId = prefs.getItemId()
        Log.i(ItemFragment.TAG, "Id = $prefsId")
    }

}