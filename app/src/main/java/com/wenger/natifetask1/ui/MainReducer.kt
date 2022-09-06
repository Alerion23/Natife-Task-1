package com.wenger.natifetask1.ui

import com.wenger.natifetask1.base.Reducer

class MainReducer(lastId: Int) : Reducer<MainViewState, MainEvent> {

    override val initState = MainViewState(lastId, false)

    override fun reduce(state: MainViewState, event: MainEvent): MainViewState {
        return when (event) {
            is MainEvent.CreateList -> state
            is MainEvent.CheckItemId -> state
            is MainEvent.ItemIdChecked -> state.copy(
                lastItemId = event.lastId,
                isIdExist = event.isIdExist
            )
            is MainEvent.ListCreated -> state
        }
    }
}