package com.wenger.natifetask1.ui.fragments.item

import android.util.Log
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.data.Prefs

class ItemPresenterImpl(
    _view: ItemView,
    _prefs: Prefs
) : ItemPresenter {

    private val view: ItemView = _view
    private val prefs: Prefs = _prefs

    override fun getItemDetails(itemId: Int) {
        val item = ItemList.getItemById(itemId)
        val id = item?.id
        val name = item?.name
        val description = item?.description
        view.showItemDetails(id, name, description)
    }

    override fun getIdAndLog() {
        val prefsId = prefs.getItemId()
        Log.i(ItemFragment.TAG, "Id = $prefsId")
    }
}