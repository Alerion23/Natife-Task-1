package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.model.Item
import java.lang.Exception

sealed class ListEvent {

    object LoadList : ListEvent()
    object ItemIdSaved: ListEvent()
    data class ListLoaded(val list: List<Item>): ListEvent()
    data class SaveItemId(val id: Int) : ListEvent()
    data class Error(val error: Exception): ListEvent()
}
