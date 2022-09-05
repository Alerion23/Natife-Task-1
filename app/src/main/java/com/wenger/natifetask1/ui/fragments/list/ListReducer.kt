package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.base.Reducer

class ListReducer : Reducer<ListViewStates, ListEvent> {

    override val initState = ListViewStates(list = arrayListOf())

    override fun reduce(state: ListViewStates, event: ListEvent): ListViewStates {
        return when (event) {
            is ListEvent.LoadList -> state
            is ListEvent.SaveItemId -> state
            is ListEvent.ListLoaded -> state.copy(list = event.list)
            is ListEvent.Error -> state
        }
    }
}