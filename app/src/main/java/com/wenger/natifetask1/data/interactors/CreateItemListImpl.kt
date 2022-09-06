package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.ui.MainEvent
import com.wenger.natifetask1.ui.MainViewState

class CreateItemListImpl : Interactor<MainViewState, MainEvent> {

    override fun invoke(state: MainViewState, event: MainEvent): MainEvent {
        if (event is MainEvent.CreateList) {
            if (ItemList.getList().size != 20) {
                ItemList.createList()
            }
        }
        return MainEvent.ListCreated
    }
}