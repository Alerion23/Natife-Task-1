package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.ui.fragments.list.ListEvent
import com.wenger.natifetask1.ui.fragments.list.ListViewState

class SaveItemIdImpl(
    private val prefs: Prefs
) : Interactor<ListViewState, ListEvent> {

    override fun invoke(state: ListViewState, event: ListEvent): ListEvent {
        if (event is ListEvent.SaveItemId) {
            prefs.setItemId(event.id)
        }
        return ListEvent.ItemIdSaved
    }
}