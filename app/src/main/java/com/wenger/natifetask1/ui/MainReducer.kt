package com.wenger.natifetask1.ui

import com.wenger.natifetask1.base.Reducer

class MainReducer: Reducer<MainViewStates, MainEvent> {

    override val initState = MainViewStates(lastItemId = -1)

    override fun reduce(state: MainViewStates, event: MainEvent): MainViewStates {
        return when (event) {
            is MainEvent.CreateList -> state
            is MainEvent.CheckItemId -> state
            is MainEvent.ItemIdChecked -> state.copy(lastItemId = event.lastId)
        }
    }
}