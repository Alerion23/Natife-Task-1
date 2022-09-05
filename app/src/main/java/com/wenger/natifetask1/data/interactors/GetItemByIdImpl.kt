package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.ui.fragments.item.ItemEvent
import com.wenger.natifetask1.ui.fragments.item.ItemViewStates

class GetItemByIdImpl : Interactor<ItemViewStates, ItemEvent> {

    override fun invoke(state: ItemViewStates, event: ItemEvent): ItemEvent {
        return if (event is ItemEvent.GetItemDetails) {
            ItemEvent.ItemDetailsReceived(item = ItemList.getItemById(event.id))
        } else {
            throw IllegalArgumentException("No item")
        }
    }
}