package com.wenger.natifetask1.ui.fragments.item

import com.wenger.natifetask1.base.Reducer

class ItemReducer(itemId: Int) : Reducer<ItemViewState, ItemEvent> {

    override val initState: ItemViewState = ItemViewState(itemId, null)

    override fun reduce(state: ItemViewState, event: ItemEvent): ItemViewState {
        return when (event) {
            is ItemEvent.GetItemIdAndLog -> state
            is ItemEvent.GetItemDetails -> state.copy(id = event.id)
            is ItemEvent.ItemDetailsReceived -> state.copy(item = event.item)
            is ItemEvent.Error -> state
            is ItemEvent.ItemIdLogged -> state
        }
    }
}