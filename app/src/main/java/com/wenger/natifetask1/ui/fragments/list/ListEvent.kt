package com.wenger.natifetask1.ui.fragments.list

sealed class ListEvent {

    object GetList : ListEvent()
    class SaveItemId(val id: Int) : ListEvent()
}
