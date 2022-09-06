package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.base.Reducer

class ListReducer : Reducer<ListViewState, ListEvent> {

    override val initState = ListViewState(list = listOf())

    override fun reduce(state: ListViewState, event: ListEvent): ListViewState {
        return when (event) {
            is ListEvent.LoadList -> state
            is ListEvent.SaveItemId -> state
            is ListEvent.ItemIdSaved -> state
            is ListEvent.ListLoaded -> state.copy(list = event.list)
            is ListEvent.Error -> state
        }
    }
}