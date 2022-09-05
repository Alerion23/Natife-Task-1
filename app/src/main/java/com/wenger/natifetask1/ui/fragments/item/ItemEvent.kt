package com.wenger.natifetask1.ui.fragments.item

import com.wenger.natifetask1.model.Item
import java.lang.Exception

sealed class ItemEvent {

    object GetItemIdAndLog : ItemEvent()
    data class GetItemDetails(val id: Int): ItemEvent()
    data class ItemDetailsReceived(val item: Item?): ItemEvent()
    data class Error(val error: Exception): ItemEvent()
}
