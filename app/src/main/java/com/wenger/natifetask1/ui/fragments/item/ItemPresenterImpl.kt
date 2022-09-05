package com.wenger.natifetask1.ui.fragments.item

import android.util.Log
import com.wenger.natifetask1.data.interactors.GetItemByIdInteractor
import com.wenger.natifetask1.data.interactors.GetItemIdInteractor

class ItemPresenterImpl(
    private val view: ItemView,
    private val getItemId: GetItemIdInteractor,
    private val getItemById: GetItemByIdInteractor
) : ItemPresenter {

    private fun getItemDetails(itemId: Int) {
        val item = getItemById.execute(itemId)
        if (item != null) {
            val id = item.id
            val name = item.name
            val description = item.description
            reducer(ItemViewStates.DisplayedItemDetails(id, name, description))
        }
    }

    private fun getIdAndLog() {
        val prefsId = getItemId.execute()
        Log.i(ItemFragment.TAG, "Id = $prefsId")
    }

    override fun obtainEvent(event: ItemEvent) {
        when (event) {
            is ItemEvent.GetItemDetails -> {
                getItemDetails(event.itemId)
            }
            is ItemEvent.GetItemIdAndLog -> {
                getIdAndLog()
            }
        }
    }

    private fun reducer(state: ItemViewStates) {
        view.render(state)
    }
}