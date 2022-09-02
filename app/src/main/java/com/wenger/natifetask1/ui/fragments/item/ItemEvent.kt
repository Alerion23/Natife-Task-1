package com.wenger.natifetask1.ui.fragments.item

sealed class ItemEvent {

    class GetItemDetails(val itemId: Int): ItemEvent()
    object GetItemIdAndLog : ItemEvent()
}
