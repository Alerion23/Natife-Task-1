package com.wenger.natifetask1.ui.fragments.item

import com.wenger.natifetask1.base.Reducer

class ItemReducer : Reducer<ItemViewStates, ItemEvent> {

    override val initState: ItemViewStates = ItemViewStates(-1, null)

    override fun reduce(state: ItemViewStates, event: ItemEvent): ItemViewStates {
        return when (event) {
            is ItemEvent.GetItemIdAndLog -> state
            is ItemEvent.GetItemDetails -> state.copy(id = event.id)
            is ItemEvent.ItemDetailsReceived -> state.copy(item = event.item)
            is ItemEvent.Error -> state
        }
    }
}