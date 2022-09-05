package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.base.UnitInteractor
import com.wenger.natifetask1.ui.MainEvent
import com.wenger.natifetask1.ui.MainViewStates

class CreateItemListImpl : UnitInteractor<MainViewStates, MainEvent> {

    override fun invoke(state: MainViewStates, event: MainEvent) {
        if (event is MainEvent.CreateList) {
            if (ItemList.getList().size != 20) {
                ItemList.createList()
            }
        }
    }
}