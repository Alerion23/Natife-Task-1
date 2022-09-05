package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.ui.fragments.list.ListEvent
import com.wenger.natifetask1.ui.fragments.list.ListViewStates

class GetItemListImpl: Interactor<ListViewStates, ListEvent> {

    override fun invoke(state: ListViewStates, event: ListEvent): ListEvent {
        return if (event is ListEvent.LoadList) {
            ListEvent.ListLoaded(list = ItemList.getList())
        } else {
            ListEvent.Error(IllegalArgumentException("Wrong action"))
        }
    }
}